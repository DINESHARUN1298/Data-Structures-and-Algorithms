package dev.dinesh.leetcode.algorithms.stringmanipulation;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for(int index = 0; index < s.length(); index++) {
            if(s.charAt(index) != ' ') {
                word.append(s.charAt(index));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
}