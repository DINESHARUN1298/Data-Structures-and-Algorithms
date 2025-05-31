package dev.dinesh.leetcode.datastructures.array;

public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for(int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for(int colIndex = 0; colIndex < matrix[0].length; colIndex++) {
                transposedMatrix[colIndex][rowIndex] = matrix[rowIndex][colIndex];
            }
        }
        return transposedMatrix;
    }

}
