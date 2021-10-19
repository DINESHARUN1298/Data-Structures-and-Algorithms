package dev.dinesh.leetcode.datastructures.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int index = 0; index < nums.length; index++) {
            int num = nums[index];
            int complement = target - num;
            if(numsMap.containsKey(complement)) {
                return new int[] {numsMap.get(complement), index};
            } else {
                numsMap.put(num, index);
            }
        }
        return null;
    }
}