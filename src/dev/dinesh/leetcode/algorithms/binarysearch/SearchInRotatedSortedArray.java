package dev.dinesh.leetcode.algorithms.binarysearch;

public class SearchInRotatedSortedArray {

    public int findRotateIndex(int[] nums, int left, int right) {
        if(nums[left] < nums[right]) {
            return 0;
        }
        while(left <= right) {
            int pivot = (left + right) / 2;
            if(nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
                if(nums[pivot] < nums[left]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return 0;
    }

    public int searchTarget(int[] nums, int target, int left, int right) {
        while(left <= right) {
            int pivot = (left + right) / 2;
            if(nums[pivot] == target) {
                return pivot;
            } else {
                if(target < nums[pivot]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if(nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int rotatedIndex = findRotateIndex(nums, 0, nums.length-1);
        if(nums[rotatedIndex] == target) {
            return rotatedIndex;
        }
        if(rotatedIndex == 0) {
            return searchTarget(nums, target, rotatedIndex, nums.length-1);
        }
        if(target < nums[0]) {
            return searchTarget(nums, target, rotatedIndex, nums.length-1);
        }
        return searchTarget(nums, target, 0, rotatedIndex);
    }

}