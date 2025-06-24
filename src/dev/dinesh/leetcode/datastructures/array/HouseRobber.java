package dev.dinesh.leetcode.datastructures.array;

import java.util.Arrays;

public class HouseRobber {

    private class intialSolution {

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

            if(this.memo[index] != -1) {
                return this.memo[index];
            }

            int ans = Math.max(this.robFrom(index+1, nums), this.robFrom(index+2, nums) + nums[index]);
            this.memo[index] = ans;
            return ans;

        }

        // SOLUTION IS RECURSION WITH MEMOIZATION
        // TIME COMPLEXITY: O(N)
        // SPACE COMPLEXITY: O(N)

    }

    private class alternateSolution1 {

        public int rob(int[] nums) {

            int N = nums.length;

            if(N == 0) {
                return 0;
            }

            int[] maxRobbedAmount = new int[N + 1];

            maxRobbedAmount[N] = 0;
            maxRobbedAmount[N - 1] = nums[N - 1];

            for(int index = N - 2; index >= 0; index--) {
                maxRobbedAmount[index] = Math.max((maxRobbedAmount[index+2] + nums[index]), maxRobbedAmount[index+1]);
            }

            return maxRobbedAmount[0];

        }

    }

    // SOLUTION IS DYNAMIC PROGRAMMING
    // TIME COMPLEXITY: O(N)
    // SPACE COMPLEXITY: O(N)

    private class alternateSolution2 {

        public int rob(int[] nums) {

            int N = nums.length;

            if(N == 0) {
                return 0;
            }

            int robNextPlusOne = 0;
            int robNext = nums[N - 1];

            for(int index = N - 2; index >= 0; index--) {
                int currentRobbedAmount = Math.max((robNextPlusOne + nums[index]), robNext);
                robNextPlusOne = robNext;
                robNext = currentRobbedAmount;

            }

            return robNext;

        }

    }

    // SOLUTION IS DYNAMIC PROGRAMMING WITH TWO VARIABLE TRACKING
    // TIME COMPLEXITY: O(N)
    // SPACE COMPLEXITY: O(N)

}
