package dev.dinesh.leetcode.preparation.amazon;

public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {

        int[] arr = new int[length];

        for(int[] update : updates) {
            int startIndex = update[0];
            int endIndex = update[1];
            int incrementValue = update[2];
            arr[startIndex] += incrementValue;
            if(endIndex+1 < length) {
                arr[endIndex+1] -= incrementValue;
            }
        }

        for(int index = 1; index < length; index++) {
            arr[index] += arr[index-1];
        }

        return arr;

    }
}