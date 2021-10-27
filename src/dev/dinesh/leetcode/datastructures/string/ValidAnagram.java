package dev.dinesh.leetcode.datastructures.string;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for(int index = 0; index < s.length(); index++) {
            counter[s.charAt(index) - 'a']++;
            counter[t.charAt(index) - 'a']--;
        }
        for(int cnt : counter) {
            if(cnt != 0) {
                return false;
            }
        }
        return true;
    }
}
