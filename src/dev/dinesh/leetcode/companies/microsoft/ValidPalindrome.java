package dev.dinesh.leetcode.companies.microsoft;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int start = 0, end = len - 1;
        while(start < end) {
            while(start < end && !Character.isDigit(s.charAt(start)) && !Character.isLetter(s.charAt(start))) {
                start++;
            }
            while(start < end && !Character.isDigit(s.charAt(end)) && !Character.isLetter(s.charAt(end))) {
                end--;
            }
            Character ch1 = s.charAt(start);
            ch1 = Character.toLowerCase(ch1);
            Character ch2 = s.charAt(end);
            ch2 = Character.toLowerCase(ch2);
            if(ch1 != ch2) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}