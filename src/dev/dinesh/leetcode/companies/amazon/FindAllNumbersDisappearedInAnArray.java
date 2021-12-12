package dev.dinesh.leetcode.companies.amazon;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] cnt = new int[nums.length+1];
        List<Integer> disappearedNumbers = new ArrayList<Integer>();
        for(int index = 0; index < nums.length; index++) {
            cnt[nums[index]]++;
        }
        for(int index = 1; index <= nums.length; index++) {
            if(cnt[index] == 0) {
                disappearedNumbers.add(index);
            }
        }
        return disappearedNumbers;
    }
}