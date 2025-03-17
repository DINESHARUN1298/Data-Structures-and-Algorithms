package dev.dinesh.leetcode.companies.microsoft;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagramsSolution1(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }

        return new ArrayList<>(groups.values());

    }

    /**
     * Solution 1: Sorted strings as keys
     * Time Complexity: O(N*K*logK)
     * Space Complexity: O(N*K)
     */

    public List<List<String>> groupAnagramsSolution2(String[] strs) {

        Map<String, List<String>> groups = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]);
                sb.append('#');
            }

            String key = sb.toString();

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
        }

        return new ArrayList<>(groups.values());

    }

    /**
     * Solution 2: Array with character occurrence count and a delimiter
     * Time Complexity: O(N*K + N*A)
     * Space Complexity: O(N*K + N*A)
     */

}