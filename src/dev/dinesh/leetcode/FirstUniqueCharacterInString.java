package dev.dinesh.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInString {

    public int firstUniqueChar(String s) {
        Map<Character, Integer> counter = new HashMap<>();
        for (int index = 0; index < s.length(); index++) {
            Character ch = s.charAt(index);
            if (!counter.containsKey(ch)) {
                counter.put(s.charAt(index), index);
            } else {
                counter.put(s.charAt(index), -1);
            }
        }

        int minIndex = Integer.MAX_VALUE;

        for (char ch : counter.keySet()) {
            int currentValue = counter.get(ch);
            if (currentValue > -1 && currentValue < minIndex) {
                minIndex = currentValue;
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;

    }

}