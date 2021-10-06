package dev.dinesh.leetcode.mock;

import java.util.Arrays;

public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[0]-a[1], b[0]-b[1]));
        int totalCost = 0;
        for(int index = 0; index < costs.length; index++) {
            if(index < costs.length/2) {
                totalCost += costs[index][0];
            } else {
                totalCost += costs[index][1];
            }
        }
        return totalCost;
    }
}