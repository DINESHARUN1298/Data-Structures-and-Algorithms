package dev.dinesh.leetcode.datastructures.array;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;

        if(rows == 0) {
            return false;
        }

        int cols = matrix[0].length;

        int left = 0, right = rows * cols - 1;
        int pivotIndex, pivotElement;

        while(left <= right) {
            pivotIndex = (left + right) / 2;
            pivotElement = matrix[pivotIndex/rows][pivotIndex%cols];
            if(pivotElement == target) {
                return true;
            } else {
                if(target < pivotElement) {
                    right = pivotIndex - 1;
                } else {
                    left = pivotIndex + 1;
                }
            }
        }

        return false;
    }
}