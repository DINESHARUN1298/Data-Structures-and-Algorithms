package dev.dinesh.leetcode.datastructures.array;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c) {
            return mat;
        }
        int originalColIndex = 0, originalRowIndex = 0, originalCols = mat[0].length;
        int[][] result = new int[r][c];
        for(int rowIndex = 0; rowIndex < r; rowIndex++) {
            for(int colIndex = 0; colIndex < c; colIndex++) {
                if(originalColIndex == originalCols) {
                    originalRowIndex++;
                    originalColIndex = 0;
                }
                result[rowIndex][colIndex] = mat[originalRowIndex][originalColIndex++];
            }
        }
        return result;
    }
}