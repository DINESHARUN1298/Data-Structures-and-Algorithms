package dev.dinesh.leetcode.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> ans = new ArrayList<StringBuilder>();
        ans.add(new StringBuilder());
        for(char ch : s.toCharArray()) {
            int n = ans.size();
            if(Character.isLetter(ch)) {
                for(int index = 0; index < n; index++) {
                    ans.add(new StringBuilder(ans.get(index)));
                    ans.get(index).append(Character.toLowerCase(ch));
                    ans.get(n + index).append(Character.toUpperCase(ch));
                }
            } else {
                for(int index = 0; index < n; index++) {
                    ans.get(index).append(ch);
                }
            }
        }
        List<String> result = new ArrayList<>();
        for(int index = 0; index < ans.size(); index++) {
            result.add(ans.get(index).toString());
        }
        return result;
    }
}