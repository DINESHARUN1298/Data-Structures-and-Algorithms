package dev.dinesh.leetcode.algorithms.bfs;

import javafx.util.Pair;
import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {

        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();
        int freshOranges = 0;
        int rows = grid.length, cols = grid[0].length;

        // Build the set of rotten oranges

        for(int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for(int colIndex = 0; colIndex < cols; colIndex++) {
                if  (grid[rowIndex][colIndex] == 2) {
                    queue.offer(new Pair(rowIndex, colIndex));
                } else if(grid[rowIndex][colIndex] == 1) {
                    freshOranges++;
                }
            }
        }

        // Mark the level complete -> increase the timestamp

        queue.offer(new Pair(-1, -1));

        // Start the rotting via BFS
        int minutesElapsed = -1;
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int row = pair.getKey();
            int col = pair.getValue();
            if(row == -1) {
                minutesElapsed++;
                if(!queue.isEmpty()) {
                    queue.offer(new Pair(-1, -1));
                }
            } else {
                for(int[] d : directions) {
                    int neighborRow = row+ d[0];
                    int neighborCol = col + d[1];
                    if(neighborRow >= 0 && neighborRow < rows && neighborCol >= 0 && neighborCol < cols) {
                        if(grid[neighborRow][neighborCol] == 1) {
                            grid[neighborRow][neighborCol] = 2;
                            freshOranges--;
                            queue.offer(new Pair(neighborRow, neighborCol));
                        }
                    }
                }
            }
        }
        return freshOranges == 0 ? minutesElapsed : -1;
    }

}