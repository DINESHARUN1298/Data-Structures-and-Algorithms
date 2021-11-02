package dev.dinesh.leetcode.algorithms;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int index = -1;
        int pivot, left = 0, right = nums.length-1;
        while(left <= right) {
            pivot = left + (right - left)/2;
            if(target == nums[pivot]) {
                return pivot;
            } else if(target < nums[pivot]) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return index;
    }
}