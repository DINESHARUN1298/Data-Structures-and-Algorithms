package dev.dinesh.leetcode.datastructures.array;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int minVal = prices[0];

        for(int index = 1; index < prices.length; index++) {
            minVal = Math.min(minVal, prices[index]);
            maxProfit = Math.max(maxProfit, prices[index] - minVal);
        }

        return maxProfit;

    }
}