package dev.dinesh.leetcode.easy;

public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1, pointer = nums.length - 1;
        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[pointer--] = nums[left] * nums[left];
                left++;
            } else {
                result[pointer--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}