package dev.dinesh.leetcode.contests.contest1;

public class CountVowelSubstringsOfAString {

    public boolean isVowelSubstring(String word) {
        if (word.length() < 5) {
            return false;
        }
        for (char ch : word.toCharArray()) {
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                return false;
            }
        }
        if (word.indexOf('a') != -1 && word.indexOf('e') != -1 && word.indexOf('i') != -1 && word.indexOf('o') != -1 && word.indexOf('u') != -1) {
            return true;
        }
        return false;
    }

    public int countVowelSubstrings(String word) {
        int cnt = 0;
        for (int rowIndex = 0; rowIndex < word.length(); rowIndex++) {
            for (int colIndex = rowIndex + 1; colIndex < word.length(); colIndex++) {
                if ((word.charAt(rowIndex) == 'a' || word.charAt(rowIndex) == 'e' || word.charAt(rowIndex) == 'i' || word.charAt(rowIndex) == 'o' || word.charAt(rowIndex) == 'u') && (word.charAt(colIndex) == 'a' || word.charAt(colIndex) == 'e' || word.charAt(colIndex) == 'i' || word.charAt(colIndex) == 'o' || word.charAt(colIndex) == 'u')) {
                    if (isVowelSubstring(word.substring(rowIndex, colIndex + 1))) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

}