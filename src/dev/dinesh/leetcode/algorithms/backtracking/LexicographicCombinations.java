package dev.dinesh.leetcode.algorithms.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LexicographicCombinations {

    public List<List<Integer>> combine(int n, int k) {

        LinkedList<Integer> nums = new LinkedList<Integer>();

        for(int index = 1; index <= k; index++) {
            nums.add(index);
        }

        nums.add(n+1);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int subIndex = 0;

        while(subIndex < k) {
            result.add(new LinkedList(nums.subList(0, k)));
            subIndex = 0;
            while((subIndex < k) && (nums.get(subIndex + 1) == nums.get(subIndex) + 1)) {
                nums.set(subIndex, subIndex++ + 1);
            }
            nums.set(subIndex, nums.get(subIndex) + 1);
        }

        return result;

    }

}