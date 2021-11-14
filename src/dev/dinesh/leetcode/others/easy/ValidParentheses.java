package dev.dinesh.leetcode.others.easy;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()) {
            if(ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            } else if(ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if(ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if(ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

/**

    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.


        Example 1:

        Input: s = "()"
        Output: true

        Example 2:

        Input: s = "()[]{}"
        Output: true

        Example 3:

        Input: s = "(]"
        Output: false

        Example 4:

        Input: s = "([)]"
        Output: false

        Example 5:

        Input: s = "{[]}"
        Output: true

        Constraints:

        1 <= s.length <= 104
        s consists of parentheses only '()[]{}'.

 */