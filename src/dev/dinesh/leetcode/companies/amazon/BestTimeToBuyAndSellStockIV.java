package dev.dinesh.leetcode.companies.amazon;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0 || k == 0) {
            return 0;
        }
        int[] buys = new int[k];
        Arrays.fill(buys, Integer.MIN_VALUE);
        int[] sells = new int[k];
        Arrays.fill(sells, 0);
        for(int index = 0; index < prices.length; index++) {
            for(int subIndex = 0; subIndex < k; subIndex++) {
                if(subIndex > 0) {
                    buys[subIndex] = Math.max(buys[subIndex], sells[subIndex-1] - prices[index]);
                } else {
                    buys[subIndex] = Math.max(buys[subIndex], -prices[index]);
                }
                sells[subIndex] = Math.max(sells[subIndex], buys[subIndex] + prices[index]);
            }
        }
        return sells[k-1];
    }
}