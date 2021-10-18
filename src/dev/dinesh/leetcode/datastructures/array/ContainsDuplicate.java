package dev.dinesh.leetcode.datastructures.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int index = 0; index < nums.length; index++) {
            set.add(nums[index]);
        }
        if(set.size() == nums.length) {
            return false;
        }
        return true;
    }
}