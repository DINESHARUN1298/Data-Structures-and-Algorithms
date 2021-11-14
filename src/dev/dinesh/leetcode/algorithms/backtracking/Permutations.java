package dev.dinesh.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Permutations {

    public void backtrack(int n, ArrayList<Integer> nums, List<List<Integer>> output, int first) {
        if(first == n) {
            output.add(new ArrayList<Integer>(nums));
        }
        for(int index = first; index < n; index++) {
            Collections.swap(nums, first, index);
            backtrack(n, nums, output, first+1);
            Collections.swap(nums, index, first);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList();
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int num : nums) {
            numList.add(num);
        }
        backtrack(nums.length, numList, output, 0);
        return output;
    }

}