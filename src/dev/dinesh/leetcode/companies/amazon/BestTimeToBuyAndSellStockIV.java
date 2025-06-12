package dev.dinesh.leetcode.companies.amazon;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int index = 0; index < prices.length - 1; index++) {
                if (prices[index] < prices[index + 1]) {
                    profit += prices[index + 1] - prices[index];
                }
            }
            return profit;
        }
        int[] buys = new int[k];
        Arrays.fill(buys, Integer.MIN_VALUE);
        int[] sells = new int[k];
        Arrays.fill(sells, 0);
        for (int index = 0; index < prices.length; index++) {
            for (int subIndex = 0; subIndex < k; subIndex++) {
                if (subIndex > 0) {
                    buys[subIndex] = Math.max(buys[subIndex], sells[subIndex - 1] - prices[index]);
                } else {
                    buys[subIndex] = Math.max(buys[subIndex], -prices[index]);
                }
                sells[subIndex] = Math.max(sells[subIndex], buys[subIndex] + prices[index]);
            }
        }
        return sells[k - 1];
    }

    public int alternateApproach(int k, int[] prices) {

        int[][] dp = new int[k + 1][prices.length];

        if (prices.length < 2) {
            return 0;
        }

        for (int rowIndex = 1; rowIndex <= k; rowIndex++) {
            int effectiveBuyPrice = prices[0];
            for (int colIndex = 1; colIndex < prices.length; colIndex++) {
                dp[rowIndex][colIndex] = Math.max(dp[rowIndex][colIndex - 1], prices[colIndex] - effectiveBuyPrice);
                effectiveBuyPrice = Math.min(effectiveBuyPrice, prices[colIndex] - dp[rowIndex - 1][colIndex]);
            }
        }
        return dp[k][prices.length - 1];
    }

    // TIME COMPLEXITY: O (k * n)
    // SPACE COMPLEXITY: O (k * n)

}