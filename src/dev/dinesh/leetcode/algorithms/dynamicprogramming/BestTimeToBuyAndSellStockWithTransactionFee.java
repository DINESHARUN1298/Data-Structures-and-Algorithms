package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {

        int maxProfit = 0;
        int effectiveBuyPrice = prices[0];

        for(int index = 1; index < prices.length; index++) {
            maxProfit = Math.max(maxProfit, prices[index] - effectiveBuyPrice - fee);
            effectiveBuyPrice = Math.min(effectiveBuyPrice, prices[index] - maxProfit);
        }

        return maxProfit;

    }

}

// TIME COMPLEXITY: O(N)
// SPACE COMPLEXITY: O(1)