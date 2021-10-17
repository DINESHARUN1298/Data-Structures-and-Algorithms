package dev.dinesh.leetcode.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {

        if(intervals == null || intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> priorityQueue =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>(){
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(int[] a, int[] b) {
                        return a[0] - b[0];
                    }
                });

        priorityQueue.add(intervals[0][1]);

        for(int index = 1; index < intervals.length; index++) {

            if(intervals[index][0] >= priorityQueue.peek()) {
                priorityQueue.poll();
            }

            priorityQueue.add(intervals[index][1]);

        }

        return priorityQueue.size();

    }
}