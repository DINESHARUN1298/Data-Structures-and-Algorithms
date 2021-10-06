package dev.dinesh.leetcode.medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int goodPositionIndex = nums.length - 1;
        for(int index = nums.length - 1; index >= 0; index--) {
            if(nums[index] + index >= goodPositionIndex) {
                goodPositionIndex = index;
            }
        }
        return goodPositionIndex == 0;
    }
}