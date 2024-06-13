package  com.warship.leedcode.daily._21_04;

/**
 * 633. 平方数之和
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 *
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 *
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 *
 *
 * 提示：
 *
 * 0 <= c <= 231 - 1
 */
public class _4_28_JudgeSquareSum {
    /**
     * 这是最一开始的想法，暴力解。都从o开始，到 c结束遍历
     * <p>
     * 后来发现不需要到c才结束，最多到 根号c
     * <p>
     * 后来又发现，当 i*i + j*j > c时，不需要继续遍历，就可以break当前遍历 这时测试用例已经通过大半
     * <p>
     * 后来又发现，j不需要从0开始，从i开始就可以保证遍历所有可能出现的情况。 这时测试用例仅有四五个通过不了。
     * <p>
     * 后来发现，已经没什么可以优化的了，应该是思路出现问题。
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        double d = c;
        int high = (int) Math.ceil(Math.sqrt(d));
        for (int i = 0; i <= high; i++) {
            for (int j = i; j <= high; j++) {
                int tmp = i * i + j * j;
                if (tmp == c) {
                    System.out.println(i + "," + j);
                    return true;
                }
                if (tmp > c) {
                    System.out.println(tmp);
                    break;
                }
            }
        }
        return false;
    }


    /**
     * 改变了思路，想到j不一定要从头开始，可以从尾部开始，双指针。
     * 就过了
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum_(int c) {
        double d = c;
        int low = 0;
        int high = (int) Math.ceil(Math.sqrt(d));
        while (low <= high) {
            int tmp = low * low + high * high;
            if (tmp == c) {
                System.out.println(low + ",," + high);
                return true;
            } else if (tmp > c) {

                high--;
            } else {
                low++;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        _4_28_JudgeSquareSum test = new _4_28_JudgeSquareSum();
        boolean b = test.judgeSquareSum_(5);
        System.out.println(b);

    }
}
