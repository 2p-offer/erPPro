package com.warship.test.leedcode.daily._21_04;

import java.util.HashMap;
import java.util.Map;

/**
 * 87. 扰乱字符串
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 */
public class _4_16_IsScramble {


    String s1;
    String s2;
    int[][][] container;

    /**
     * 1.当s1.length != s2.length 时，肯定不是扰乱串
     * 2.当s1 和 s2 出现的字符种类及数量对不上时，肯定不是扰乱串
     * 3.如果s1.equals(s2) 则一定是扰乱串
     * 4：设 F(s1,s2) 为 s1 ,s2 是否是扰乱串
     * 设 S(x,y) 为 将S 从 x处截取 y长度的字符
     * s1 从 i 处 分割 记为 l1(0,i) 和  r1(i,length)，如果 s1 和 s2 为扰乱串，则有：
     * F(l1(0,i),l2(0,i))&& F(r1(i,length - i),r2(i,length -i))  切割后 ，字符串没有交换
     * 或者：
     * F(l1(0,i),r2(length-i,i)) && F(r1(i,length - i),l2(0,length-i))
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        this.s1 = s1;
        this.s2 = s2;
        container = new int[length][length][length + 1];

        return checkScramble(0, 0, length);
    }

    /**
     * @param i1
     * @param i2
     * @param length
     * @return
     */
    private boolean checkScramble(int i1, int i2, int length) {

        return false;
    }

    /**
     * 判断 s1 从i1截取 length  s2从i2截取length ，的两个字符串，所出现的所有字符是否一样多
     *
     * @param i1
     * @param i2
     * @param length
     * @return
     */
    private boolean checkSameTime(int i1, int i2, int length) {
        Map<Integer, Integer> charMap = new HashMap<>();
        int forLength = i1 + length;
        for (int i = i1; i < forLength; i++) {
            int c = s1.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        forLength = i2 + length;
        for (int i = i2; i < forLength; i++) {
            int c = s2.charAt(i);
            charMap.put(c, charMap.getOrDefault(c, 0) - 1);
        }
        for (int value : charMap.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _4_16_IsScramble test = new _4_16_IsScramble();
        test.s1 = "abcdefa";
        test.s2 = "aabcdef";
        boolean b = test.checkSameTime(1, 1, 4);
        System.out.println(b);
    }
}
