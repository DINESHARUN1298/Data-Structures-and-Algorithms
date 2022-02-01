package dev.dinesh.leetcode.companies.microsoft;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        if(nums[left] < nums[right]) {
            return nums[left];
        }
        while(right > left) {
            int pivot = left + (right - left) / 2;
            if(nums[pivot] > nums[pivot + 1]) {
                return nums[pivot + 1];
            } else if(nums[pivot - 1] > nums[pivot]) {
                return nums[pivot];
            }
            if(nums[pivot] > nums[0]) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
        return -1;
    }

}

/**
 *  Solution is based on binary search.
 *  Reason:  Time complexity is expected as O(log N)
 *  Edge Case: The array may not be rotated, hence need to check the first element
 */