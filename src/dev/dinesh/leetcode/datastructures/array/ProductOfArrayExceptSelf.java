package dev.dinesh.leetcode.datastructures.array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for(int index = 1; index < length; index++) {
            answer[index] = nums[index-1] * answer[index-1];
        }
        int R = 1;
        for(int index = length-1; index >= 0; index--) {
            answer[index] = answer[index] * R;
            R *= nums[index];
        }
        return answer;
    }
}