package dev.dinesh.leetcode.dailychallenge;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int bitMask = 0;
        for(int num : nums) {
            bitMask ^= num;
        }
        int diff = bitMask & (-bitMask);
        int x = 0;
        for(int num : nums) {
            if((num & diff) != 0) {
                x = x ^ num;
            }
        }
        return new int[]{x, bitMask ^ x};
    }
}