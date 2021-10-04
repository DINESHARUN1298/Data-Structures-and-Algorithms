package dev.dinesh.leetcode;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for(int index = 0; index < prices.length - 1; index++) {
            if(prices[index+1] > prices[index]) {
                profit += prices[index+1] - prices[index];
            }
        }
        return profit;
    }
}