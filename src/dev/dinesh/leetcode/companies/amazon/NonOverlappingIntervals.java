package dev.dinesh.leetcode.companies.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for(int index = 1; index < intervals.length; index++) {
            int[] prev = list.getLast();
            int[] curr = intervals[index];
            if(prev[1] > curr[0]) {
                prev[1] = Math.min(prev[1], curr[1]);
                list.removeLast();
                list.addLast(prev);
            } else {
                list.addLast(curr);
            }
        }
        return intervals.length - list.size();
    }
}