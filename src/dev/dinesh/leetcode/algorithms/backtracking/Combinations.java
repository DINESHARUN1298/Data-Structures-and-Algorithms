package dev.dinesh.leetcode.algorithms.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Recursive has same time complexity as iterative but real time appending of list is much slower
 */

public class Combinations {

    List<List<Integer>> result = new LinkedList();
    int n;
    int k;

    public void backtrack(int first, LinkedList<Integer> curr) {

        if(curr.size() == k) {
            result.add(new LinkedList(curr));
        }

        for(int index = first; index <= n; index++) {
            curr.add(index);
            backtrack(index+1, curr);
            curr.removeLast();
        }

    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<Integer>());
        return result;
    }

}