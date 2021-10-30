package dev.dinesh.leetcode.preparation.amazon;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        groups[0] = 1;
        int groupCnt = 0, cnt = 0;
        for(int index = 1; index < s.length(); index++) {
            if(s.charAt(index) != s.charAt(index-1)) {
                groups[++groupCnt] = 1;
            } else {
                groups[groupCnt]++;
            }
        }
        for(int index = 1; index <= groupCnt; index++) {
            cnt += Math.min(groups[index] , groups[index-1]);
        }
        return cnt;
    }
}