package dev.dinesh.leetcode.datastructures.array;

import java.util.*;

public class SortMatrixByDiagonals {

    public int[][] sortMatrix(int[][] grid) {

        int n = grid.length;
        Map<Integer, List<Integer>> elementsSorterMap = new HashMap<>();

        // Store elements of each diagonal in a HashMap

        for(int rowIndex = 0; rowIndex < n; rowIndex++) {
            for(int colIndex = 0; colIndex < n; colIndex++) {
                int currentKey = rowIndex - colIndex;
                elementsSorterMap.putIfAbsent(currentKey, new ArrayList<>());
                elementsSorterMap.get(currentKey).add(grid[rowIndex][colIndex]);
            }
        }

        // Sort diagonals based on quadrant

        for(int key : elementsSorterMap.keySet()) {
            List<Integer> values = elementsSorterMap.get(key);
            if(key >= 0) {
                values.sort(Collections.reverseOrder());
            } else {
                Collections.sort(values);
            }
        }

        // Place sorted values back into the matrix

        for(int rowIndex = 0; rowIndex < n; rowIndex++) {
            for(int colIndex = 0; colIndex < n; colIndex++) {
                grid[rowIndex][colIndex] = elementsSorterMap.get(rowIndex - colIndex).remove(0);
            }
        }

        return grid;

    }

}
