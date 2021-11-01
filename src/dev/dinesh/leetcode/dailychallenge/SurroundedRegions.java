package dev.dinesh.leetcode.dailychallenge;

import java.util.LinkedList;
import java.util.List;

/**
 * Daily Challenge - #1
 * Date - 02-11-2021
 * Approach - DFS. Need to check on other approach with BFS and then converting it to DFS
 */

public class SurroundedRegions {

    protected Integer ROWS = 0;
    protected Integer COLS = 0;

    class Pair<U, V> {
        public U first;
        public V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    protected void dfs(char[][] board, int rowIndex, int colIndex) {

        if(board[rowIndex][colIndex] != 'O') {
            return;
        }

        board[rowIndex][colIndex] = 'E';

        if(colIndex < this.COLS - 1) {
            dfs(board, rowIndex, colIndex+1);
        }

        if(rowIndex < this.ROWS - 1) {
            dfs(board, rowIndex+1, colIndex);
        }

        if(colIndex > 0) {
            dfs(board, rowIndex, colIndex-1);
        }

        if(rowIndex > 0) {
            dfs(board, rowIndex-1, colIndex);
        }

    }

    public void solve(char[][] board) {

        this.ROWS = board.length;
        this.COLS = board[0].length;

        List<Pair<Integer, Integer>> borders = new LinkedList<Pair<Integer, Integer>>();

        // Construct list of border cells

        for(int rowIndex = 0; rowIndex < this.ROWS; rowIndex++) {
            borders.add(new Pair(rowIndex, 0));
            borders.add(new Pair(rowIndex, this.COLS-1));
        }

        for(int colIndex = 0; colIndex < this.COLS; colIndex++) {
            borders.add(new Pair(0, colIndex));
            borders.add(new Pair(this.ROWS-1, colIndex));
        }

        // Mark the escaped cells

        for(Pair<Integer, Integer> pair : borders) {
            this.dfs(board, pair.first, pair.second);
        }

        // Flip the values

        for(int rowIndex = 0; rowIndex < this.ROWS; rowIndex++) {
            for(int colIndex = 0; colIndex < this.COLS; colIndex++) {
                if(board[rowIndex][colIndex] == 'O') {
                    board[rowIndex][colIndex] = 'X';
                } else if(board[rowIndex][colIndex] == 'E') {
                    board[rowIndex][colIndex] = 'O';
                }
            }
        }

    }

}