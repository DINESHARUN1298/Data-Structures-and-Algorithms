package dev.dinesh.leetcode.algorithms.slidingwindow;

public class PermutationInString {

    public boolean matches(int[] map1, int[] map2) {
        for(int index = 0; index < 26; index++) {
            if(map1[index] != map2[index]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for(int index = 0; index < s1.length(); index++) {
            s1map[s1.charAt(index) - 'a']++;
            s2map[s2.charAt(index) - 'a']++;
        }
        for(int index = 0; index < s2.length() - s1.length(); index++) {
            if(matches(s1map, s2map)) {
                return true;
            }
            s2map[s2.charAt(index) - 'a']--;
            s2map[s2.charAt(index + s1.length()) - 'a']++;
        }
        return matches(s1map, s2map);
    }

}