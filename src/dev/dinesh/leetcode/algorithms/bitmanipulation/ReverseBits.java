package dev.dinesh.leetcode.algorithms.bitmanipulation;

public class ReverseBits {
    public int reverseBits(int n) {
        int result = (n & 1);
        for(int val = 1; val < 32; val++) {
            result = result << 1;
            n >>= 1;
            result = result | (n & 1);
        }
        return result;
    }
}