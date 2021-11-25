package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int[] count = new int[10001];
        for(int x : nums) {
            count[x]++;
        }
        int prev = count[0], current = count[1], result = 0;
        for(int index = 2; index < 1001; index++) {
            result = Math.max(current, prev + index * count[index]);
            prev = current;
            current = result;
        }
        return result;
    }
}