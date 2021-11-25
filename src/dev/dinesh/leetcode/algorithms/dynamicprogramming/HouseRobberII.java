package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class HouseRobberII {

    public int rob_simple(int[] nums, int start, int end) {
        int t1 = 0;
        int t2 = 0;
        for(int index = start; index <= end; index++) {
            int temp = t1;
            t1 = Math.max(nums[index] + t2, t1);
            t2 = temp;
        }
        return t1;
    }

    public int rob(int[] nums) {

        if(nums.length == 0) {
            return 0;
        }

        if(nums.length == 1) {
            return nums[0];
        }

        int max1 = rob_simple(nums, 0, nums.length-2);
        int max2 = rob_simple(nums, 1, nums.length-1);

        return Math.max(max1, max2);

    }

}