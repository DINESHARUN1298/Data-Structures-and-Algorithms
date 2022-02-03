package dev.dinesh.leetcode.companies.microsoft;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int index = 0; index < stones.length; index++) {
            priorityQueue.add(stones[index]);
        }
        while(priorityQueue.size() > 1) {
            int stone1 = priorityQueue.remove();
            int stone2 = priorityQueue.remove();
            if(stone1 != stone2) {
                priorityQueue.add(stone1 - stone2);
            }
        }
        return priorityQueue.size() == 1 ? priorityQueue.poll() : 0;
    }
}