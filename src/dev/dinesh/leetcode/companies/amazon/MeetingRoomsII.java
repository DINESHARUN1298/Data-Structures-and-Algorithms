package dev.dinesh.leetcode.companies.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        PriorityQueue priorityQueue = new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        priorityQueue.add(intervals[0]);
        for(int index = 1; index < intervals.length; index++) {
            int[] prev = (int[]) priorityQueue.poll();
            int[] curr = intervals[index];
            if(prev[1] > curr[0]) {
                priorityQueue.add(prev);
                priorityQueue.add(curr);
            } else {
                prev[1] = curr[1];
                priorityQueue.add(prev);
            }
        }
        return priorityQueue.size();
    }
}