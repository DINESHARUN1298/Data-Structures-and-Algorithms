package dev.dinesh.leetcode.datastructures.array;

import java.util.Arrays;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int value : nums1) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }
        int index = 0;
        for(int value : nums2) {
            int cnt = hashMap.getOrDefault(value, 0);
            if(cnt > 0) {
                cnt--;
                nums1[index++] = value;
                hashMap.put(value, cnt);
            }
        }
        return Arrays.copyOfRange(nums1, 0, index);
    }
}