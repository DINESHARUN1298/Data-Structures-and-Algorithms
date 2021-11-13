package dev.dinesh.leetcode.companies.amazon;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslandsBFSApproach {
    public int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int numberOfIslands = 0;

        if(grid == null ||rows == 0) {
            return 0;
        }

        for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for(int colIndex = 0; colIndex < cols; colIndex++) {
                if(grid[rowIndex][colIndex] == '1') {
                    numberOfIslands++;
                    grid[rowIndex][colIndex] = '0';
                    Queue<Integer> neighbours = new LinkedList<>();
                    neighbours.add(rowIndex * cols + colIndex);
                    while(!neighbours.isEmpty()) {
                        int currValue = neighbours.remove();
                        int rowVal = currValue / cols;
                        int colVal = currValue % cols;
                        if(rowVal - 1 >= 0 && grid[rowVal-1][colVal] == '1') {
                            neighbours.add((rowVal-1) * cols + colVal);
                            grid[rowVal-1][colVal] = '0';
                        }
                        if(rowVal + 1 < rows && grid[rowVal+1][colVal] == '1') {
                            neighbours.add((rowVal+1) * cols + colVal);
                            grid[rowVal+1][colVal] = '0';
                        }
                        if(colVal - 1 >= 0 && grid[rowVal][colVal-1] == '1') {
                            neighbours.add(rowVal * cols + (colVal-1));
                            grid[rowVal][colVal-1] = '0';
                        }
                        if(colVal + 1 < cols && grid[rowVal][colVal+1] == '1') {
                            neighbours.add(rowVal * cols + (colVal+1));
                            grid[rowVal][colVal+1] = '0';
                        }
                    }
                }
            }
        }
        return numberOfIslands;
    }
}