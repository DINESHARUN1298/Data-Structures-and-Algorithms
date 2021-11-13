package dev.dinesh.leetcode.companies.amazon;

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

/**

    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

        A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

        Example 1:

        Input: digits = "23"
        Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        Example 2:

        Input: digits = ""
        Output: []

        Example 3:

        Input: digits = "2"
        Output: ["a","b","c"]

        Constraints:

        0 <= digits.length <= 4
        digits[i] is a digit in the range ['2', '9'].

 */