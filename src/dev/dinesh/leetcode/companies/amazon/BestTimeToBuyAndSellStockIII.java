package dev.dinesh.leetcode.companies.amazon;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) {
            return 0;
        }
        int fb = Integer.MIN_VALUE, sb = Integer.MIN_VALUE;
        int fs = 0, ss = 0;
        for(int index = 0; index < prices.length; index++) {
            fb = Math.max(fb, -prices[index]);
            fs = Math.max(fs, fb + prices[index]);
            sb = Math.max(sb, fs - prices[index]);
            ss = Math.max(ss, sb + prices[index]);
        }
        return ss;
    }
}