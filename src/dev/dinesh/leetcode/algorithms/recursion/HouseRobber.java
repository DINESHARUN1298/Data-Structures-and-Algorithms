package dev.dinesh.leetcode.algorithms.recursion;

import java.util.Arrays;

public class HouseRobber {
    private int[] memo;

    public int rob(int[] nums) {
        this.memo = new int[100];
        Arrays.fill(this.memo, -1);
        return this.robFrom(0, nums);
    }

    private int robFrom(int index, int[] nums) {
        if(index >= nums.length) {
            return 0;
        }
        if(this.memo[index] > -1) {
            return this.memo[index];
        }
        int ans = Math.max(this.robFrom(index + 1, nums), this.robFrom(index + 2, nums) + nums[index]);
        this.memo[index] = ans;
        return ans;
    }

}