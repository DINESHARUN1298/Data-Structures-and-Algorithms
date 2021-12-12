package dev.dinesh.leetcode.companies.amazon;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for(String s : strs) {
            Arrays.fill(count, 0);
            for(char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int index = 0; index < 26; index++) {
                sb.append('#');
                sb.append(count[index]);
            }
            String key = sb.toString();
            if(!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}