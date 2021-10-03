package dev.dinesh.leetcode;

public class SingleNumber {

    public int singleNumber(int[] numArray) {
        int ans = numArray[0];
        for (int index = 1; index < numArray.length; index++) {
            ans = ans ^ numArray[index];
        }
        return ans;
    }

}