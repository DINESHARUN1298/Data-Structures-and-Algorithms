package dev.dinesh.leetcode;

public class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        int indexPointer = 1;
        int pow = 1;
        for(int index = 1; index <= n; index++) {
            if(index == pow) {
                result[index] = 1;
                pow <<= 1;
                indexPointer = 1;
            } else {
                result[index] = result[indexPointer] + 1;
                indexPointer++;
            }
        }
        return result;
    }
}