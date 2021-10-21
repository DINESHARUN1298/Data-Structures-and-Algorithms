package dev.dinesh.leetcode.datastructures.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalsTriangle = new ArrayList<List<Integer>>();

        pascalsTriangle.add(new ArrayList<>());
        pascalsTriangle.get(0).add(1);

        for(int rowIndex = 1; rowIndex < numRows; rowIndex++) {

            List<Integer> currentList = new ArrayList<>();
            List<Integer> previousList = pascalsTriangle.get(rowIndex - 1);

            currentList.add(1);

            for(int colIndex = 1; colIndex < rowIndex; colIndex++) {
                currentList.add(previousList.get(colIndex-1) + previousList.get(colIndex));
            }

            currentList.add(1);
            pascalsTriangle.add(currentList);

        }

        return pascalsTriangle;

    }
}