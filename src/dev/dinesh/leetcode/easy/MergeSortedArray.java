package dev.dinesh.leetcode.easy;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstArrayIndex = m - 1, secondArrayIndex = n - 1, actualIndex = m + n - 1;
        while(secondArrayIndex >= 0) {
            if(firstArrayIndex >= 0 && nums1[firstArrayIndex] > nums2[secondArrayIndex]) {
                nums1[actualIndex--] = nums1[firstArrayIndex--];
            } else {
                nums1[actualIndex--] = nums2[secondArrayIndex--];
            }
        }
    }
}