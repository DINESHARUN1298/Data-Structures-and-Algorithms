package dev.dinesh.leetcode.datastructures.string;

import java.util.HashMap;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magazineMap = new HashMap<>();
        for(Character ch : magazine.toCharArray()) {
            magazineMap.put(ch, magazineMap.getOrDefault(ch, 0) + 1);
        }
        for(Character ch : ransomNote.toCharArray()) {
            if(magazineMap.containsKey(ch)) {
                int cnt = magazineMap.get(ch);
                if(cnt == 0) {
                    return false;
                } else {
                    magazineMap.put(ch, cnt-1);
                }
            } else {
                return false;
            }
        }
        return true;
    }
}