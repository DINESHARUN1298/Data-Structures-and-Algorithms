package dev.dinesh.leetcode;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        long currentValue = 1;
        while (currentValue < n) {
            currentValue *= 2;
        }
        return currentValue == n;
    }

}