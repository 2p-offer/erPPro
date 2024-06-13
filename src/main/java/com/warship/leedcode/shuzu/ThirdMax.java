package  com.warship.leedcode.shuzu;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * 示例 2：
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * 示例 3：
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *  
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 *  
 */
public class ThirdMax {
    public static int thirdMax(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }


//        for (int j = 0; j < 2; j++) {
//            for (int x = j; x < 2; x++) {
//                if (nums[x] < nums[x + 1]) {
//                    int tmp = nums[x];
//                    nums[x] = nums[x + 1];
//                    nums[x + 1] = tmp;
//                }
//
//            }
//        }
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = nums[i];
            if (tmp > first) {
                third = second;
                second = first;
                first = tmp;
            } else if (tmp == first) {
                continue;
            } else if (tmp > second) {
                third = second;
                second = tmp;
            } else if (tmp == second) {
                continue;
            } else if (tmp > third) {
                third = tmp;
            }
        }
        return (int) (third == Long.MIN_VALUE ? first : third);
    }

    public static void main(String[] args) {
        int[] test = new int[]{3, 2, 1};
        int i = ThirdMax.thirdMax(test);
        System.out.println(i);
    }
}
