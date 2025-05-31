package dev.dinesh.leetcode.datastructures.array;

import java.util.*;

public class SortTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {

        Map<Integer, List<Integer>> diagonalElementsMap = new HashMap<>();

        for(int rowIndex = 0; rowIndex < mat.length; rowIndex++) {
            for(int colIndex = 0; colIndex < mat[0].length; colIndex++) {
                int key = rowIndex - colIndex;
                diagonalElementsMap.putIfAbsent(key, new ArrayList());
                diagonalElementsMap.get(key).add(mat[rowIndex][colIndex]);
            }
        }

        for(int key : diagonalElementsMap.keySet()) {
            Collections.sort(diagonalElementsMap.get(key));
        }

        for(int rowIndex = 0; rowIndex < mat.length; rowIndex++) {
            for(int colIndex = 0; colIndex < mat[0].length; colIndex++) {
                int key = rowIndex - colIndex;
                mat[rowIndex][colIndex] = diagonalElementsMap.get(key).remove(0);
            }
        }

        return mat;

    }

}
