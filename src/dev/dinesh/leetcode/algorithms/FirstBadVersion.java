package dev.dinesh.leetcode.algorithms;

public class FirstBadVersion {

    public boolean isBadVersion(int index) {
        return true;
    }

    public int firstBadVersion(int n) {
        int pivot, left = 1, right = n;
        while(left < right) {
            pivot = left + (right - left) / 2;
            if(isBadVersion(pivot)) {
                right = pivot;
            } else {
                left = pivot + 1;
            }
        }
        return left;
    }

}