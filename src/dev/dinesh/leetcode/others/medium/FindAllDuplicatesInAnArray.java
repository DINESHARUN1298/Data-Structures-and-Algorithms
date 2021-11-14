package dev.dinesh.leetcode.others.medium;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        for(int index = 0; index < nums.length; index++) {
            int currIndex = Math.abs(nums[index]) - 1;
            if(nums[currIndex] < 0) {
                result.add(currIndex + 1);
            }
            nums[currIndex] = -nums[currIndex];
        }
        return result;
    }
}