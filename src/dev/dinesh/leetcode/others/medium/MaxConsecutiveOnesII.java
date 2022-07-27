package dev.dinesh.leetcode.others.medium;

public class MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {

        int maxSequence = 0, left = 0, right = 0, zeroCnt = 0;

        while(right < nums.length) {

            if(nums[right] == 0) {
                zeroCnt++;
            }

            while(zeroCnt == 2) {
                if(nums[left] == 0) {
                    zeroCnt--;
                }
                left++;
            }

            maxSequence = Math.max(maxSequence, right - left + 1);
            right++;

        }

        return maxSequence;

    }

}