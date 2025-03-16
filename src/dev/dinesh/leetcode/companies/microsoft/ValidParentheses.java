package dev.dinesh.leetcode.companies.microsoft;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    private static final Map<Character,Character> map = new HashMap<>();

    public boolean isValid(String s) {
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.add(c);
            } else {
                if(stack.isEmpty()) {
                    return false;
                }
                char open = stack.pop();
                if(map.get(open) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

/**
 * Solution: Stack
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */