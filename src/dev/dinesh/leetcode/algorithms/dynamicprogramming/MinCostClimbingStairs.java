package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        int index = 2;
        for(; index < cost.length; index++) {
            dp[index] = cost[index] + Math.min(dp[index-1], dp[index-2]);
        }
        return Math.min(dp[index-1], dp[index-2]);
    }
}