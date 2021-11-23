package dev.dinesh.leetcode.algorithms.binarysearch;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int firstTargetIndex = findBound(nums, target, true);

        if(firstTargetIndex == -1) {
            return new int[]{-1, -1};
        }

        int lastTargetIndex = findBound(nums, target, false);

        return new int[]{firstTargetIndex, lastTargetIndex};
    }

    public int findBound(int[] nums, int target, boolean isFirst) {

        int begin = 0, end = nums.length-1;
        int pivot;

        while(begin <= end) {
            pivot = begin + (end - begin) / 2;
            if(nums[pivot] == target) {
                if(isFirst) {
                    if(begin == pivot || nums[pivot-1] != target) {
                        return pivot;
                    }
                    end = pivot-1;
                } else {
                    if(end == pivot || nums[pivot+1] != target) {
                        return pivot;
                    }
                    begin = pivot + 1;
                }

            } else if(nums[pivot] < target) {
                begin = pivot + 1;
            } else {
                end = pivot - 1;
            }
        }

        return -1;

    }

}