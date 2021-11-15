package dev.dinesh.leetcode.algorithms.dynamicprogramming;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int[] dp = new int[rows+1];
        for(int rowIndex = rows-1; rowIndex >= 0; rowIndex--) {
            for(int colIndex = 0; colIndex <= rowIndex; colIndex++) {
                dp[colIndex] = Math.min(dp[colIndex], dp[colIndex+1]) + triangle.get(rowIndex).get(colIndex);
            }
        }
        return dp[0];
    }
}