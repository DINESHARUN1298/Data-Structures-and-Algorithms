package dev.dinesh.leetcode.dailychallenge;

public class UniquePathsIII {

    int rows, cols;
    int[][] grid;
    int path_count;

    public void backtrack(int row, int col, int remain) {

        if(this.grid[row][col] == 2 && remain == 1) {
            this.path_count++;
            return;
        }

        int temp = grid[row][col];
        grid[row][col] -= 4;
        remain--;

        int[] row_offsets = {0, 0, 1, -1};
        int[] col_offsets = {1, -1, 0, 0};

        for(int index = 0; index < 4; index++) {

            int next_row = row + row_offsets[index];
            int next_col = col + col_offsets[index];

            if(next_row < 0 || next_row >= this.rows || next_col < 0 || next_col >= this.cols || grid[next_row][next_col] < 0) {
                continue;
            }

            backtrack(next_row, next_col, remain);

        }

        grid[row][col] = temp;

    }

    public int uniquePathsIII(int[][] grid) {

        int non_obstacles = 0, start_row = 0, start_col = 0;
        this.rows = grid.length;
        this.cols = grid[0].length;

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                int cell = grid[row][col];
                if(cell >= 0) {
                    non_obstacles++;
                }
                if(cell == 1) {
                    start_row = row;
                    start_col = col;
                }
            }
        }

        this.path_count = 0;
        this.grid = grid;

        backtrack(start_row, start_col, non_obstacles);

        return this.path_count;

    }

}