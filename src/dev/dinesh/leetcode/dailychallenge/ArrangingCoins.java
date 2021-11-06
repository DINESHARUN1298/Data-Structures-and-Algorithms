package dev.dinesh.leetcode.dailychallenge;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long left = 0, right = n;
        long mid, curr;
        while(left <= right) {
            mid = left + (right - left) / 2;
            curr = mid * (mid + 1) / 2;
            if(curr == n) {
                return (int) mid;
            } else if(curr > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)right;
    }
}