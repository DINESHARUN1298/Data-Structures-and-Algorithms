package dev.dinesh.leetcode.companies.microsoft;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> strList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strList);
        return String.join(" ", strList);
    }
}