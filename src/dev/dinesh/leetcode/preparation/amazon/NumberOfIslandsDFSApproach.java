package dev.dinesh.leetcode.preparation.amazon;

public class NumberOfIslandsDFSApproach {
    public void dfs(char[][] grid, int rowIndex, int colIndex) {
        int rows = grid.length;
        int cols = grid[0].length;
        if(rowIndex < 0 || rowIndex >= rows || colIndex < 0 || colIndex >= cols || grid[rowIndex][colIndex] == '0') {
            return;
        }
        grid[rowIndex][colIndex] = '0';
        dfs(grid, rowIndex+1, colIndex);
        dfs(grid, rowIndex-1, colIndex);
        dfs(grid, rowIndex, colIndex+1);
        dfs(grid, rowIndex, colIndex-1);
        return;
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int numberOfIslands = 0;
        for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for(int colIndex = 0; colIndex < cols; colIndex++) {
                if(grid[rowIndex][colIndex] == '1') {
                    numberOfIslands++;
                    dfs(grid, rowIndex, colIndex);
                }
            }
        }
        return numberOfIslands;
    }
}