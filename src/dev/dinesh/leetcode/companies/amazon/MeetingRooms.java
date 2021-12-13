package dev.dinesh.leetcode.companies.amazon;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int[] prev = intervals[0];
        for(int index = 1; index < intervals.length; index++) {
            int[] current = intervals[index];
            if(prev[1] > current[0]) {
                return false;
            }
            prev = current;
        }
        return true;
    }
}