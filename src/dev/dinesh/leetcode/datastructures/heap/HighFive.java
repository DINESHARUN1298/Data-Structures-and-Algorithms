package dev.dinesh.leetcode.datastructures.heap;

import java.util.*;

public class HighFive {

    private int K;

    public int[][] highFive(int[][] items) {

        this.K = 5;
        TreeMap<Integer, Queue<Integer>> allScores = new TreeMap<>();

        for(int[] item : items) {
            int id = item[0];
            int score = item[1];
            if(!allScores.containsKey(id)) {
                allScores.put(id, new PriorityQueue<>());
            }
            allScores.get(id).add(score);
            if(allScores.get(id).size() > this.K) {
                allScores.get(id).poll();
            }
        }

        List<int[]> solution = new ArrayList<>();

        for(int id : allScores.keySet()) {

            int sum = 0;

            for(int i = 0; i < this.K; ++i) {
                sum += allScores.get(id).poll();
            }

            solution.add(new int[] {id, sum / this.K});

        }

        int[][] solutionArray = new int[solution.size()][];
        return solution.toArray(solutionArray);

    }

}
