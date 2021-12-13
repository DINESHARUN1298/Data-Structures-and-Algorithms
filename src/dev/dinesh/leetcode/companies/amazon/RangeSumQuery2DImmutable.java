package dev.dinesh.leetcode.companies.amazon;

public class RangeSumQuery2DImmutable {

        int[][] dp;

        public RangeSumQuery2DImmutable(int[][] matrix) {
            if(matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            int rows = matrix.length;
            int cols = matrix[0].length;
            dp = new int[rows+1][cols+1];
            for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
                for(int colIndex = 0; colIndex < cols; colIndex++) {
                    dp[rowIndex+1][colIndex+1] = matrix[rowIndex][colIndex] + dp[rowIndex][colIndex+1] + dp[rowIndex+1][colIndex] - dp[rowIndex][colIndex];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row2 + 1][col1] - dp[row1][col2 + 1] + dp[row1][col1];
        }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

}