package  com.warship.leedcode.daily._21_04;

/**
 * 263. 丑数
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 *
 * 示例 2：
 * 输入：n = 8
 * 输出：true
 * 解释：8 = 2 × 2 × 2
 *
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 *
 * 示例 4：
 * 输入：n = 1
 * 输出：true
 * 解释：1 通常被视为丑数。
 */
public class _4_10_IsUgly {
    public boolean res = false;

    public boolean isUgly(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        return isUgly2(n);
    }

    public boolean isUgly2(int n) {
        if (n == 2 || n == 3 || n == 5) {
            return true;
        }
        if (!res && n % 2 == 0) {
            res = isUgly(n / 2);
        }
        if (!res && n % 3 == 0) {
            res = isUgly(n / 3);
        }
        if (!res && n % 5 == 0) {
            res = isUgly(n / 5);
        }
        return res;

    }
}
