package dev.dinesh.leetcode.easy;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0, counter = 0, size = nums.length;
        for(int index = 0; index < size; index++) {
            if(nums[index] == 1) {
                counter++;
            } else {
                if(counter > maxOnes) {
                    maxOnes = counter;
                }
                counter = 0;
            }
        }
        if(counter > maxOnes) {
            maxOnes = counter;
        }
        return maxOnes;
    }
}

/**
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * Example 2:
 *
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * nums[i] is either 0 or 1.
 *
 */