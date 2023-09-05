package com.warship.test.leedcode.动态规划;

public class _08_01_WaysToStep {
    public static int waysToStep(int n) {
        if (n == 1) {
            return n;
        }
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 1; i <= n; i++) {
            int tmp = c;
            c = c + b + a;
            c %= 1000000007;
            a = b;
            b = tmp;
        }
        return c;
    }

    public static void main(String[] args) {
        int i = waysToStep(61);
        System.out.println(i);
    }
}
