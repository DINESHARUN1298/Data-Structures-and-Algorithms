package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minVal = prices[0];
        for(int index = 1; index < prices.length; index++) {
            minVal = Math.min(minVal, prices[index]);
            maxProfit = Math.max(maxProfit, prices[index] - minVal);
        }
        return maxProfit;
    }
}