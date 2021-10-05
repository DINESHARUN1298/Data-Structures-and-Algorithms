package dev.dinesh.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> symbols = new HashMap<>();
        symbols.put('I', 1);
        symbols.put('V', 5);
        symbols.put('X', 10);
        symbols.put('L', 50);
        symbols.put('C', 100);
        symbols.put('D', 500);
        symbols.put('M', 1000);
        int val = 0;
        for (int index = 0; index < s.length(); index++) {
            Character ch = s.charAt(index);
            if (index > 0 && symbols.get(ch) > symbols.get(s.charAt(index - 1))) {
                val = val + symbols.get(ch) - 2 * symbols.get(s.charAt(index - 1));
            } else {
                val += symbols.get(ch);
            }
        }
        return val;
    }
}