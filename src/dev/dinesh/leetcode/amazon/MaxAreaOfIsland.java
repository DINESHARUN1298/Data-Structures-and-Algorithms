package dev.dinesh.leetcode.amazon;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int maxSum = 0;
        for(int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
            for(int colIndex = 0; colIndex < grid[rowIndex].length; colIndex++) {
                if(grid[rowIndex][colIndex] == 1) {
                    maxSum = Math.max(maxSum, dfs(grid, rowIndex, colIndex));
                }
            }
        }
        return maxSum;
    }
    public int dfs(int[][] grid, int rowIndex, int colIndex) {
        if(rowIndex < 0 || rowIndex >= grid.length || colIndex < 0 || colIndex >= grid[rowIndex].length || grid[rowIndex][colIndex] == 0) {
            return 0;
        }
        int sum = 1;
        grid[rowIndex][colIndex] = 0;
        sum += dfs(grid, rowIndex - 1, colIndex);
        sum += dfs(grid, rowIndex + 1, colIndex);
        sum += dfs(grid, rowIndex, colIndex - 1);
        sum += dfs(grid, rowIndex, colIndex + 1);
        return sum;
    }
}