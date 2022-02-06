package dev.dinesh.leetcode.companies.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        if(nums.length == k) {
            return nums;
        }

        Map<Integer, Integer> frequency = new HashMap<>();
        for(int n : nums) {
            frequency.put(n, frequency.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> frequency.get(a) - frequency.get(b));

        for(int n : frequency.keySet()) {
            priorityQueue.add(n);
            if(priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for(int index = k-1; index >= 0; index--) {
            result[index] = priorityQueue.poll();
        }

        return result;

    }

}