package dev.dinesh.leetcode.datastructures.stack;

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