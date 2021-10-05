package dev.dinesh.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[] mapping = {
                "0",
                "1",
                "abc",
                "def",
                "ghi",
                "jkl",
                "mno",
                "pqrs",
                "tuv",
                "wxyz"
        };
        getLetterCombinationRecursively(result, digits, "", 0, mapping);
        return result;
    }

    public void getLetterCombinationRecursively(List<String> result, String digits, String currentResult, int index, String[] mapping) {
        if (index == digits.length()) {
            result.add(currentResult);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int loopVar = 0; loopVar < letters.length(); loopVar++) {
            getLetterCombinationRecursively(result, digits, currentResult + letters.charAt(loopVar), index + 1, mapping);
        }
    }

}