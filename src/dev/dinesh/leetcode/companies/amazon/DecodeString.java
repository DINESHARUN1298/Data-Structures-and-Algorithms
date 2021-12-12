package dev.dinesh.leetcode.companies.amazon;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String>  strStack = new Stack<>();
        int index = 0;
        String str = "";
        while(index < s.length()) {
            char ch = s.charAt(index);
            if(Character.isDigit(ch)) {
                int num = 0;
                while(Character.isDigit(ch)) {
                    num = num * 10 + (ch - '0');
                    index++;
                    ch = s.charAt(index);
                }
                intStack.push(num);
            } else if(ch == '[') {
                strStack.push(str);
                str = "";
                index++;
            } else if(ch == ']') {
                int count = intStack.pop();
                String strValue = strStack.pop();
                StringBuilder sb = new StringBuilder(strValue);
                for(int ctr = 0; ctr < count; ctr++) {
                    sb.append(str);
                }
                str = sb.toString();
                index++;
            } else {
                str += ch;
                index++;
            }
        }
        return str;
    }
}