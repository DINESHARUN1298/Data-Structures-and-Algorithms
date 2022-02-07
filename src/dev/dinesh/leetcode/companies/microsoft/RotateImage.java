package dev.dinesh.leetcode.companies.microsoft;

public class RotateImage {

    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for(int rowIndex = 0; rowIndex < n; rowIndex++) {
            for(int colIndex = rowIndex + 1; colIndex < n; colIndex++) {
                int temp = matrix[rowIndex][colIndex];
                matrix[rowIndex][colIndex] = matrix[colIndex][rowIndex];
                matrix[colIndex][rowIndex] = temp;
            }
        }
    }

    public void reflect(int[][] matrix) {
        int n = matrix.length;
        for(int rowIndex = 0; rowIndex < n; rowIndex++) {
            for(int colIndex = 0; colIndex < n/2; colIndex++) {
                int temp = matrix[rowIndex][colIndex];
                matrix[rowIndex][colIndex] = matrix[rowIndex][n - colIndex - 1];
                matrix[rowIndex][n - colIndex - 1] = temp;
            }
        }
    }

}