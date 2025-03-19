package dev.dinesh.leetcode.companies.microsoft;

public class RotateImage {

    public void rotateSolution1(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i < (n + 1) / 2; i++) {
            for(int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    public void rotateSolution2(int[][] matrix) {
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

/**
 * Solution 1: Select group of entries and swap them clockwise
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */

/**
 * Solution 2: Transpose a matrix first, then reflect it
 * Time Complexity: O(N^2)
 * Space Complexity: O(1)
 */