package dev.dinesh.leetcode.algorithms.twopointers;

public class MoveZeros {
    public void moveZeroes(int[] nums) {
        for(int lastNonZeroIndex = 0, currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            if(nums[currentIndex] != 0) {
                int temp = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex++] = nums[currentIndex];
                nums[currentIndex] = temp;
            }
        }
    }
}