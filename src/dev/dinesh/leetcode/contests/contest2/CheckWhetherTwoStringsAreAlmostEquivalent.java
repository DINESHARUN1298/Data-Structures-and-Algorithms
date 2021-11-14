package dev.dinesh.leetcode.contests.contest2;

public class CheckWhetherTwoStringsAreAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int[] wordCnt1 = new int[128];
        int[] wordCnt2 = new int[128];
        for(int index = 0; index < word1.length(); index++) {
            wordCnt1[word1.charAt(index)]++;
            wordCnt2[word2.charAt(index)]++;
        }
        for(int index = 97; index <= 122; index++) {
            int diff = wordCnt1[index] - wordCnt2[index];
            if(diff < -3 || diff > 3) {
                return false;
            }
        }
        return true;
    }
}