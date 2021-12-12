package dev.dinesh.leetcode.companies.amazon;

public class BestTimeToBuyAndSellStockWithCoolDown {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);
        for(int index = 2; index <prices.length; index++) {
            dp[index][0] = Math.max(dp[index-1][0], dp[index-1][1] + prices[index]);
            dp[index][1] = Math.max(dp[index-1][1], dp[index-2][0] - prices[index]);
        }
        return dp[prices.length-1][0];
    }
}