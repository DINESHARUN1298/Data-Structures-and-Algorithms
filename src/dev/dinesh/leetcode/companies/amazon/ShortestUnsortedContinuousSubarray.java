package dev.dinesh.leetcode.companies.amazon;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        int leftIndex = 0, rightIndex = 0;
        for (int index = 0; index < nums.length - 1; index++) {
            if (nums[index] > nums[index + 1]) {
                left = Math.min(left, nums[index + 1]);
            }
        }
        for (int index = nums.length - 1; index > 0; index--) {
            if (nums[index] < nums[index - 1]) {
                right = Math.max(right, nums[index - 1]);
            }
        }
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] > left) {
                leftIndex = index;
                break;
            }
        }
        for (int index = nums.length - 1; index >= 0; index--) {
            if (nums[index] < right) {
                rightIndex = index;
                break;
            }
        }
        return rightIndex - leftIndex > 0 ? rightIndex - leftIndex + 1 : 0;
    }
}