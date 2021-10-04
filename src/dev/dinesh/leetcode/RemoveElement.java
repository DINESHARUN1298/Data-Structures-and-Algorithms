package dev.dinesh.leetcode;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int insertIndex = 0;
        for(int currentValue : nums) {
            if(currentValue != val) {
                nums[insertIndex++] = currentValue;
            }
        }
        return insertIndex;
    }
}
