package dev.dinesh.leetcode.others.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> result = new LinkedList<>();

        for(int[] p : people) {
            result.add(p[1], p);
        }

        int n = people.length;
        return result.toArray(new int[n][2]);

    }
}