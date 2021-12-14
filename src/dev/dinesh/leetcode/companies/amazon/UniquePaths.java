package dev.dinesh.leetcode.companies.amazon;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int index = 0; index < m; index++) {
            dp[index][0] = 1;
        }
        for(int index = 0; index < n; index++) {
            dp[0][index] = 1;
        }
        for(int rowIndex = 1; rowIndex < m; rowIndex++) {
            for(int colIndex = 1; colIndex < n; colIndex++) {
                dp[rowIndex][colIndex] = dp[rowIndex-1][colIndex] + dp[rowIndex][colIndex-1];
            }
        }
        return dp[m-1][n-1];
    }
}