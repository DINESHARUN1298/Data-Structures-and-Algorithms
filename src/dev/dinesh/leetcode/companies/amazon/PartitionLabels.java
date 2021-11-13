package dev.dinesh.leetcode.companies.amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionResults = new ArrayList<>();
        int[] lastIndex = new int[26];
        for(int index = 0; index < s.length(); index++) {
            lastIndex[s.charAt(index)-'a'] = index;
        }
        int i = 0;
        while(i < s.length()) {
            int end = lastIndex[s.charAt(i)-'a'];
            int j = i;
            while(j != end) {
                end = Math.max(end, lastIndex[s.charAt(j++)-'a']);
            }
            partitionResults.add(j-i+1);
            i = j+1;
        }
        return partitionResults;
    }
}

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 * Example 2:
 *
 * Input: s = "eccbbbbdec"
 * Output: [10]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s consists of lowercase English letters.
 */