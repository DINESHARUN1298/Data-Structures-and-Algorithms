package dev.dinesh.leetcode.datastructures.array;

public class MaximumSubArray {
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