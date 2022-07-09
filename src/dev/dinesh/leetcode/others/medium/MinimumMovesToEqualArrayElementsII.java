package dev.dinesh.leetcode.others.medium;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {

        Arrays.sort(nums);
        long minimum = Long.MAX_VALUE, sum = 0, total = 0;

        for(int num : nums) {
            total += num;
        }

        for(int index = 0; index < nums.length; index++) {
            long result = ((long) nums[index] * index - sum) + ((total - sum) - (long) nums[index] * (nums.length - index));
            minimum = Math.min(result, minimum);
            sum += nums[index];
        }

        return (int) minimum;

    }
}