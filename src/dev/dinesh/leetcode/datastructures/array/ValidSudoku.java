package dev.dinesh.leetcode.datastructures.array;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        int N = 9;

        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for(int rowIndex = 0; rowIndex < N; rowIndex++) {
            rows[rowIndex] = new HashSet<Character>();
            cols[rowIndex] = new HashSet<Character>();
            boxes[rowIndex] = new HashSet<Character>();
        }

        for(int rowIndex = 0; rowIndex < N; rowIndex++) {

            for(int colIndex = 0; colIndex < N; colIndex++) {

                char val = board[rowIndex][colIndex];

                if(val == '.') {
                    continue;
                }

                if(rows[rowIndex].contains(val)) {
                    return false;
                }

                rows[rowIndex].add(val);

                if(cols[colIndex].contains(val)) {
                    return false;
                }

                cols[colIndex].add(val);

                int index = (rowIndex / 3) * 3 + colIndex / 3;

                if(boxes[index].contains(val)) {
                    return false;
                }

                boxes[index].add(val);

            }
        }

        return true;

    }
}