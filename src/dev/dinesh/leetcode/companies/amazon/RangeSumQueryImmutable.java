package dev.dinesh.leetcode.companies.amazon;

public class RangeSumQueryImmutable {

    int[] dp;

    public RangeSumQueryImmutable(int[] nums) {
        dp = new int[nums.length + 1];
        dp[0] = 0;
        for(int index = 1; index <= nums.length; index++) {
            dp[index] = dp[index-1] + nums[index-1];
        }
    }

    public int sumRange(int left, int right) {
        return dp[right+1] - dp[left];
    }

}