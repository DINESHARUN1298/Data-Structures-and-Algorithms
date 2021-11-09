package dev.dinesh.leetcode.datastructures.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        prev.add(1);
        for(int row = 1; row <= rowIndex+1; row++) {
            for(int colIndex = 0; colIndex < row; colIndex++) {
                if(colIndex == 0 || colIndex == row-1) {
                    current.add(1);
                } else {
                    current.add(prev.get(colIndex-1) + prev.get(colIndex));
                }
            }
            if(row == rowIndex+1) {
                break;
            }
            prev = current;
            current = new ArrayList<>();
        }
        return current;
    }
}