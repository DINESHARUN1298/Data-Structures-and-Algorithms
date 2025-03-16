package dev.dinesh.leetcode.companies.microsoft;

public class ReverseWordsInAStringII {

    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseEachWord(s);
    }

    public void reverse(char[] s, int left, int right) {
        while(left < right) {
            char temp;
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public void reverseEachWord(char[] s) {
        int strLength = s.length;
        int left = 0, right = 0;
        while(right < strLength) {
            if(s[right] == ' ') {
                reverse(s, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        reverse(s, left, strLength - 1);
    }

}

/**
   Solution: Two pointer algorithm
   Time Complexity: O(N)
   Space Complexity: O(1)
   Note: Last word will not have ' ' , hence must handle it with a final call of reverse
 */