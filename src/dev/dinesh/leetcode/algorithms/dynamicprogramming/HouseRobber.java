package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class HouseRobber {
    public int rob(int[] nums) {
        int N = nums.length;
        if(N == 0) {
            return 0;
        }
        int[] maxRobbedAmount = new int[nums.length + 1];
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N-1] = nums[N-1];
        for(int index = N-2; index >= 0; index--) {
            maxRobbedAmount[index] = Math.max(maxRobbedAmount[index+1], maxRobbedAmount[index+2] + nums[index]);
        }
        return maxRobbedAmount[0];
    }
}