package dev.dinesh.leetcode.algorithms.bfs;

public class Matrix01 {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        if(rows == 0) {
            return mat;
        }
        int cols = mat[0].length;
        int[][] result = new int[rows][cols];
        for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for(int colIndex = 0; colIndex < cols; colIndex++) {
                if(mat[rowIndex][colIndex] == 0) {
                    result[rowIndex][colIndex] = 0;
                } else {
                    result[rowIndex][colIndex] = 1000000001;
                    if(rowIndex > 0) {
                        result[rowIndex][colIndex] = Math.min(result[rowIndex][colIndex], result[rowIndex-1][colIndex]+1);
                    }
                    if(colIndex > 0) {
                        result[rowIndex][colIndex] = Math.min(result[rowIndex][colIndex], result[rowIndex][colIndex-1]+1);
                    }
                }
            }
        }
        for(int rowIndex = rows-1; rowIndex >= 0; rowIndex--) {
            for(int colIndex = cols-1; colIndex >= 0; colIndex--) {
                if(rowIndex < rows-1) {
                    result[rowIndex][colIndex] = Math.min(result[rowIndex][colIndex], result[rowIndex+1][colIndex]+1);
                }
                if(colIndex < cols-1) {
                    result[rowIndex][colIndex] = Math.min(result[rowIndex][colIndex], result[rowIndex][colIndex+1]+1);
                }
            }
        }
        return result;
    }
}