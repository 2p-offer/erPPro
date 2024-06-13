package  com.warship.leedcode.daily._21_04;

/**
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * 示例 1：
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 示例 2：
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * <p>
 * 示例 3：
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * <p>
 * 示例 4：
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 * <p>
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 */
public class _4_21_NumDecodings {
    public static int numDecodings(String s) {
        int length = s.length();
        if (length == 0)
            return 0;
        int lastInt = Character.getNumericValue(s.charAt(0));
        if (lastInt == 0) {
            return 0;
        }
        int prePreNum = 1;
        int preNum = 1;
        for (int i = 1; i < length; i++) {

            int t = preNum;
            int tmp = Character.getNumericValue(s.charAt(i));
            //分几种情况。如果tmp 是 0 。当lastInt 不是 1且 不是2 说明肯定会有 0 或者30+ 的数字组合， ；

            //如果tmp不是0, 如果 lastInt- tmp <= 26, 则当前值应该为 前一个值的值加前前值；
            if (tmp == 0) {
                if (lastInt != 1 && lastInt != 2) {
                    return 0;
                } else {
                    preNum = prePreNum;
                }
            } else {
                if (lastInt != 0 && lastInt * 10 + tmp < 27) {
                    preNum += prePreNum;
                }
            }
            lastInt = tmp;
            prePreNum = t;
        }
        return preNum;
    }

    //官方解答
    public static int numDecodings_main(String s) {
        int n = s.length();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
            System.out.println("i:" + i + ",char:" + Character.getNumericValue(s.charAt(i)) + ",fn:" + f[i]);
        }
        return f[n];
    }

    //官方解答，优化思路
    public int numDecodings_main_II(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c=f[i]
        int a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = 0;
            if (s.charAt(i - 1) != '0') {
                c += b;
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                c += a;
            }
            a = b;
            b = c;
        }
        return c;
    }

    public static void main(String[] args) {
        int i = numDecodings("2611055971756562");
        System.out.println(i);
    }
}
