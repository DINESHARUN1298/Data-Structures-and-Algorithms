package dev.dinesh.leetcode.companies.microsoft;

public class LongestPalindromicSubstring {

    // Solution 1

    public String longestPalindromeSolution1(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int end = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i > end - start) {
                    start = i;
                    end = j;
                }
            }
        }

        return s.substring(start, end + 1);

    }

    /**
     * Solution 1: Two pointer algorithm combined with DP
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     * Note: Need to ensure the edge characters in both ends are equal && the string in between is a palindrome
     * Note: Also, j - i <= 2 is base condition added for iterating edge characters for 1, 2 and 3 character words which do not need substring validation
     */

    // Solution 2

    public String longestPalindromeSolution2(String s) {

        int n = s.length();
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int left = i;
                int right = i + j;
                while (left >= 0 && right <= n - 1 && (s.charAt(left) == s.charAt(right))) {
                    left--;
                    right++;
                }
                left++;
                right--;
                if (right - left > end - start) {
                    start = left;
                    end = right;
                }
            }
        }

        return s.substring(start, end + 1);

    }

    /**
     * Solution 2: Two pointer algorithm, checks from middle based on odd / even length expansion of substring
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * Note: Need to revert the last state if the palindrome condition fails either length or character match
     */

}
