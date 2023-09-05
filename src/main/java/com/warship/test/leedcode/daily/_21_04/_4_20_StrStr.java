package com.warship.test.leedcode.daily._21_04;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回  -1 。
 * 说明：
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。
 * <p>
 * 示例 1：
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * 输入：haystack = "", needle = ""
 * 输出：0
 * 提示：
 * 0 <= haystack.length, needle.length <= 5 * 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class _4_20_StrStr {
    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle) || needle.isEmpty()) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int currentIndex = 0;
        int res = -1;
        int i = 0;
        while (i < haystack.length()) {

            if (currentIndex == needle.length()) {
                return res;
            }
            if (haystack.charAt(i) == needle.charAt(currentIndex)) {
                if (currentIndex == 0) {
                    res = i;
                }
                currentIndex++;
            } else {
                if (currentIndex != 0) {
                    i = res;
                }
                currentIndex = 0;
                res = -1;
            }
            i++;
        }
        return currentIndex == needle.length() ? res : -1;
    }


    public int strStr_main(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public int strStr_KMP(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

//        int i = strStr("mississippi", "issip");
        int i = strStr("abdcaabcbadcba", "abc");

        System.out.println(i);
    }
}
