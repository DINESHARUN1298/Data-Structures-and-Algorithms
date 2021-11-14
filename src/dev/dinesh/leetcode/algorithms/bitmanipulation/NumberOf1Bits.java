package dev.dinesh.leetcode.algorithms.bitmanipulation;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int cnt = 0;
        while(n != 0) {
            cnt++;
            n = (n & (n-1));
        }
        return cnt;
    }
}