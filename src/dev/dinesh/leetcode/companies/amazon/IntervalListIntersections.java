package dev.dinesh.leetcode.companies.amazon;

import java.util.ArrayList;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int len1 = firstList.length;
        int len2 = secondList.length;
        if(firstList == null || secondList == null || len1 == 0 || len2 == 0) {
            return new int[0][0];
        }
        int index1 = 0;
        int index2 = 0;
        ArrayList<int[]> result = new ArrayList<>();
        while(index1 < len1 && index2 < len2) {
            int max = Math.max(firstList[index1][0], secondList[index2][0]);
            int min = Math.min(firstList[index1][1], secondList[index2][1]);
            if(max <= min) {
                result.add(new int[]{max, min});
            }
            if(firstList[index1][1] < secondList[index2][1]) {
                index1++;
            } else {
                index2++;
            }
        }
        int[][] solution = new int[result.size()][2];
        int index = 0;
        for (int[] list : result) {
            solution[index++] = list;
        }
        return solution;
    }
}