package dev.dinesh.leetcode.easy;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int actual = x, reverse = 0;
        while(x > 0) {
            reverse = (reverse * 10) + (x % 10);
            x/=10;
        }
        return actual == reverse;
    }
}