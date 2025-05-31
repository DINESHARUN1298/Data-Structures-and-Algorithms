package dev.dinesh.leetcode.datastructures.array;

public class ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        for(int rowIndex = 0; rowIndex < matrix.length - 1; rowIndex++) {
            for(int colIndex = 0; colIndex < matrix[0].length - 1; colIndex++) {
                if(matrix[rowIndex][colIndex] != matrix[rowIndex + 1][colIndex + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

}
