package dev.dinesh.leetcode.others.medium;

import java.util.ArrayList;
import java.util.List;

public class ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {

        int[] inCount = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>(n + 1);

        for(int index = 0; index < n + 1; index++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int[] relation : relations) {
            graph.get(relation[0]).add(relation[1]);
            inCount[relation[1]]++;
        }

        int step = 0;
        int studiedCount = 0;
        List<Integer> bfs = new ArrayList<>();

        for(int node = 1; node < n + 1; node++) {
            if(inCount[node] == 0) {
                bfs.add(node);
            }
        }

        // Start learning with BFS
        while(!bfs.isEmpty()) {
            // Start new semester
            step++;
            List<Integer> nextQueue = new ArrayList<>();
            for(int node : bfs) {
                studiedCount++;
                for(int endNode : graph.get(node)) {
                    inCount[endNode]--;
                    // Prerequisite courses learnt
                    if(inCount[endNode] == 0) {
                        nextQueue.add(endNode);
                    }
                }
            }
            bfs = nextQueue;
        }

        // All courses completed check
        return studiedCount == n ? step : -1;

    }

}