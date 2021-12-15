package dev.dinesh.leetcode.companies.amazon;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks {
    public int connectSticks(int[] sticks) {
        if(sticks == null || sticks.length <= 1) {
            return 0;
        }
        int cost = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int index = 0; index < sticks.length; index++) {
            priorityQueue.add(sticks[index]);
        }
        while(priorityQueue.size() > 1) {
            int stick1 = priorityQueue.remove();
            int stick2 = priorityQueue.remove();
            priorityQueue.add(stick1 + stick2);
            cost += stick1 + stick2;
        }
        return cost;
    }
}