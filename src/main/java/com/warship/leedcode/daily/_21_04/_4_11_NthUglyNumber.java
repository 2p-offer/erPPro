package com.warship.test.leedcode.daily._21_04;

import java.util.*;

/**
 * 264. 丑数 II
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * <p>
 * 示例 1：
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * <p>
 * 提示：
 * 1 <= n <= 1690
 */
public class _4_11_NthUglyNumber {


    public int nthUglyNumber3(int n) {
        PriorityQueue<Long> container = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        int[] data = new int[]{2, 3, 5};
        container.offer(1L);
        set.add(1L);
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = container.poll();
            for (int d : data) {
                long tmp = res * d;
                if (set.add(tmp)) {
                    container.offer(tmp);
                }
            }
        }
        return (int) res;
    }


    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2;
            int num3 = dp[p3] * 3;
            int num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }


    List<Boolean> nthUglyNumberContainer = new ArrayList<>();

    public int nthUglyNumber(int n) {
        nthUglyNumberContainer.add(false);
        nthUglyNumberContainer.add(true);
        int currentNum = 1;
        while (n > 1) {
            currentNum++;
            if (needAdd(currentNum)) {
                n--;
                nthUglyNumberContainer.add(true);
            } else {
                nthUglyNumberContainer.add(false);
            }
        }
        return currentNum;
    }

    public boolean needAdd(int n) {
        if (n == 1 || n == 2 || n == 3 || n == 5) {
            return true;
        }
        boolean res = false;
        if (n % 2 == 0) {
            res = nthUglyNumberContainer.get(n / 2);
        }
        if (!res && n % 3 == 0) {
            res = nthUglyNumberContainer.get(n / 3);
        }
        if (!res && n % 5 == 0) {
            res = nthUglyNumberContainer.get(n / 5);
        }
        return res;
    }
}
