package dev.dinesh.leetcode;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length + 1;
        for(int value : nums) {
            sum += value;
        }
        return ((n * (n-1))/2 - sum);
    }
}