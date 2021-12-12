package dev.dinesh.leetcode.companies.amazon;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for(int coinIndex = 0; coinIndex < coins.length; coinIndex++) {
            for(int amountIndex = coins[coinIndex]; amountIndex <= amount; amountIndex++) {
                dp[amountIndex] = Math.min(dp[amountIndex], dp[amountIndex - coins[coinIndex]] + 1);
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}