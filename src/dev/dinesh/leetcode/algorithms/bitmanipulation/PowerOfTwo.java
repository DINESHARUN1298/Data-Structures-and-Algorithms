package dev.dinesh.leetcode.algorithms.bitmanipulation;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) {
            return false;
        }
        long x = (long) n;
        return (x & -x) == x;
    }
}