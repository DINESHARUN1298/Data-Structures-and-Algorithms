package dev.dinesh.leetcode.algorithms.bitmanipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for(int index = 1; index < nums.length; index++) {
            ans = ans ^ nums[index];
        }
        return ans;
    }
}