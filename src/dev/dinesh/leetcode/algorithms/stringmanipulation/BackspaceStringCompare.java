package dev.dinesh.leetcode.algorithms.stringmanipulation;

import java.util.Stack;

public class BackspaceStringCompare {

    public String processString(String str) {
        Stack<Character> ans = new Stack();
        for(char ch : str.toCharArray()) {
            if(ch != '#') {
                ans.push(ch);
            } else if(!ans.isEmpty()) {
                ans.pop();
            }
        }
        return String.valueOf(ans);
    }

    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

}