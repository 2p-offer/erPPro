package com.warship.test.leedcode.ext;

/**
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
 * <p>
 * 注意：n 是正数且在 32 位整数范围内（n < 231）。
 * 示例 1：
 * <p>
 * 输入：3
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 */
public class FindNthDigit {
    public static int findNthDigit(int n) {
        int index = 0;
        int num = 9 * (int) Math.pow(10, index);
        int byteNum = num * (index + 1);
        int delNum = 0;
        while (n > byteNum) {
            delNum += num;
            index++;
            n = n - byteNum;
            num = num * 10;
            if (byteNum == 720000000) {
                break;
            }
            byteNum = num * (index + 1);
        }

        int currentNum = n / (index + 1) + delNum;
        int yushu = n % (index + 1);
        if (yushu == 0) {
            return Character.getNumericValue(String.valueOf(currentNum).charAt(index));
        }
        return Character.getNumericValue(String.valueOf(currentNum + 1).charAt(yushu - 1));
    }

//    public static int findNthDigit(int n) {
//        int index = 0;
//        int num = 9 * (int) Math.pow(10, index);
//        int byteNum = num * (index + 1);
//        while (n > byteNum) {
//            index++;
//            n = n - byteNum;
//            num = num * 10;
//            byteNum = num * (index + 1);
//            System.out.println("n:" + n + ",num:" + num + ",byteNum:" + byteNum + ",index:" + index);
//        }
//
//        int currentNum = n / (index + 1) + (num / 10);
//        int yushu = n % (index + 1);
//        if (yushu == 0) {
//            return Character.getNumericValue(String.valueOf(currentNum).charAt(index));
//        }
//        return Character.getNumericValue(String.valueOf(currentNum + 1).charAt(yushu - 1));
//    }

    public static void main(String[] args) {
//        System.out.println(10 / 2);
//        System.out.println(11 % 2);
        int nthDigit = FindNthDigit.findNthDigit(999999999);
        System.out.println(nthDigit);
//
//        System.out.println(9 / 10);
//        int numericValue = Character.getNumericValue(String.valueOf(1134567890).charAt(8));
//        System.out.println(numericValue);
    }

    /**
     * java.lang.ArithmeticException: / by zero
     *   at line 13, Solution.findNthDigit
     *   at line 57, __DriverSolution__.__helper__
     *   at line 85, __Driver__.main
     */
}
