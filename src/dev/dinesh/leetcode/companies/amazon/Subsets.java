package dev.dinesh.leetcode.companies.amazon;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public void backtrack(int start, ArrayList<Integer> list, int[] nums) {
        result.add(new ArrayList<Integer>(list));
        for(int index = start; index < nums.length; index++) {
            list.add(nums[index]);
            backtrack(index+1, list, nums);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) {
            return result;
        }
        backtrack(0, new ArrayList<Integer>(), nums);
        return result;
    }

}