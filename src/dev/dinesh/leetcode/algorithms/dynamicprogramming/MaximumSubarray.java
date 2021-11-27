package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSubArray = nums[0];
        int currentSubArray = nums[0];
        for(int index = 1; index < nums.length; index++) {
            int num = nums[index];
            currentSubArray = Math.max(num, currentSubArray + num);
            maxSubArray = Math.max(maxSubArray, currentSubArray);
        }
        return maxSubArray;
    }
}