package dev.dinesh.leetcode;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        int cnt = 0;
        for(Character s : stones.toCharArray()) {
            if(jewels.indexOf(s) != -1) {
                cnt++;
            }
        }
        return cnt;
    }
}