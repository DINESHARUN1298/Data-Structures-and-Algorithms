package dev.dinesh.leetcode.companies.amazon;

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

/**

 Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 Example 1:

 Input: s = "leetcode"
 Output: 0

 Example 2:

 Input: s = "loveleetcode"
 Output: 2

 Example 3:

 Input: s = "aabb"
 Output: -1

 Constraints:

 1 <= s.length <= 105
 s consists of only lowercase English letters.

 */