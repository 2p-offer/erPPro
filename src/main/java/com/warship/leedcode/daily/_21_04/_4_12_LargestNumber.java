package  com.warship.leedcode.daily._21_04;

import java.util.PriorityQueue;

/**
 * 179. 最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 *
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 *
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 *
 * 示例 4：
 * 输入：nums = [10]
 * 输出："10"
 *
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class _4_12_LargestNumber {

    /**
     * 获取最高位
     *
     * @param x
     * @return
     */
    public static int getHighBit(int x) {
        if (x > 100000000) x /= 100000000;
        if (x > 10000) x /= 10000;
        if (x > 100) x /= 100;
        if (x > 10) x /= 10;
        if (x == 10) {
            return 1;
        }
        return x;
    }

    /**
     * @param a
     * @param b
     * @return
     */
    public static int getHigherInt2(int a, int b, int highBit) {
        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);
        int aLength = aStr.length();
        int bLength = bStr.length();
//        if (aLength < bLength) {
//            String tmp = bStr;
//            bStr = aStr;
//            aStr = tmp;
//            int tmpLength = bLength;
//            bLength = aLength;
//            aLength = tmpLength;
//        }

        for (int i = 0; i < aLength; i++) {

            int aCharInt = Character.getNumericValue(aStr.charAt(i));
            if (i >= bLength) {
                if (aCharInt == highBit) {
                    continue;
                }
                return aCharInt > highBit ? a : b;
            }
            int bCharInt = Character.getNumericValue(bStr.charAt(i));

            if (aCharInt == bCharInt) {
                continue;
            }
            return aCharInt > bCharInt ? a : b;
        }
        return a;
    }

    public static int getHigherInt(int a, int b) {
        Long ab = Long.valueOf(a + "" + b);
        Long ba = Long.valueOf(b + "" + a);
        return ab > ba ? a : b;
    }


    public static String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int[] stateContainer = new int[nums.length];
        int highBit = -1;
        int highIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (stateContainer[j] == 0) {
                    int tmp = getHighBit(nums[j]);
                    if (tmp > highBit) {//最高位比较，直接出结果
                        highBit = tmp;
                        highIndex = j;
                        continue;
                    }
                    if (tmp == highBit) {//最高位一样，就得顺延比较
                        int higherInt = getHigherInt(nums[highIndex], nums[j]);
                        if (higherInt == nums[j]) {
                            highBit = tmp;
                            highIndex = j;
                        }
                    }
                }
            }
            if (!"0".equals(sb.toString()) || nums[highIndex] != 0) {
                sb.append(nums[highIndex]);
            }
            stateContainer[highIndex] = 1;
            highBit = -1;
            highIndex = -1;
        }
        return sb.toString();
    }


    public static String largestNumber2(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>(nums.length, (s1, s2) -> {
            Long s1s2 = Long.valueOf(s1 + "" + s2);
            Long s2s1 = Long.valueOf(s2 + "" + s1);
            if (s1s2 < s2s1) {
                return 1;
            } else if (s2s1 < s1s2) {
                return -1;
            } else {
                return 0;
            }
        });
        for (int i = 0; i < nums.length; i++) {
            heap.add(String.valueOf(nums[i]));
        }
        StringBuilder collect = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            collect.append(heap.remove());
        }
        while (collect.length() >= 2 && collect.charAt(0) == '0' && collect.charAt(1) == '0') {
            return "0";
        }
        return collect.toString();
    }

    public static void main(String[] args) {
//        int higherInt = getHigherInt(30, 3);
//        System.out.println(higherInt);
//
        String res = largestNumber2(new int[]{1, 2});
        System.out.println(res);
//        int higherInt = getHigherInt(223, 2422, 2);
//        System.out.println(higherInt);

    }
}
