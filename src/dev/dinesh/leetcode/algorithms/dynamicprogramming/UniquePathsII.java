package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;

        for(int rowIndex = 1; rowIndex < m; rowIndex++) {
            obstacleGrid[rowIndex][0] = (obstacleGrid[rowIndex][0] == 0 && obstacleGrid[rowIndex-1][0] == 1) ? 1 : 0;
        }

        for(int colIndex = 1; colIndex < n; colIndex++) {
            obstacleGrid[0][colIndex] = (obstacleGrid[0][colIndex] == 0 && obstacleGrid[0][colIndex-1] == 1) ? 1 : 0;
        }

        for(int rowIndex = 1; rowIndex < m; rowIndex++) {
            for(int colIndex = 1; colIndex < n; colIndex++) {
                if(obstacleGrid[rowIndex][colIndex] != 1) {
                    obstacleGrid[rowIndex][colIndex] = obstacleGrid[rowIndex - 1][colIndex] + obstacleGrid[rowIndex][colIndex-1];
                } else {
                    obstacleGrid[rowIndex][colIndex] = 0;
                }
            }
        }

        return obstacleGrid[m-1][n-1];

    }
}
