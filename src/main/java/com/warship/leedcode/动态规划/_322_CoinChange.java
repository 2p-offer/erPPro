package com.warship.leedcode;

import java.util.Arrays;

public class _322_CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange1(coins, amount, new int[amount + 1]);
    }

    private static int coinChange1(int[] coins, int amount, int[] container) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        if (container[amount] != 0) {
            return container[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange1(coins, amount - coin, container);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        container[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return container[amount];
    }

    public int coinChange_for_for(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int max = amount + 1;
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == max)
            dp[amount] = -1;
        return dp[amount];
    }


    public static int coinChange_self(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 0;

        return coinChange_self_(coins, amount, dp);
    }

    private static int coinChange_self_(int[] coins, int amount, int[] dp) {
        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }
        if (dp[amount] != 0) {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int currentNum = coinChange_self_(coins, amount - coin, dp);
            if (currentNum >= 0) {
                min = Math.min(min, currentNum);
            }
        }
        dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        return dp[amount];
    }

    public static void main(String[] args) {
        int i = coinChange_self(new int[]{1, 2, 5}, 11);
        System.out.println(i);
    }
}
