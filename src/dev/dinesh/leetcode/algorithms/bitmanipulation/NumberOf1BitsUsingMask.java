package dev.dinesh.leetcode.algorithms.bitmanipulation;

public class NumberOf1BitsUsingMask {
    public int hammingWeight(int n) {
        int mask = 1;
        int cnt = 0;
        for(int index = 0; index < 32; index++) {
            if((mask & n) != 0) {
                cnt++;
            }
            mask <<= 1;
        }
        return cnt;
    }
}