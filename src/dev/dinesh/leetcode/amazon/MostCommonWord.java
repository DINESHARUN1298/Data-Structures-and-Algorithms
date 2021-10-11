package dev.dinesh.leetcode.amazon;

import java.util.HashMap;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> words = new HashMap<>();
        for(String word: banned) {
            words.put(word, -1);
        }
        StringBuilder para = new StringBuilder();
        int maxCnt = 0;
        String result = null;
        for(Character ch : paragraph.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                para.append(ch);
            } else if(ch >= 'A' && ch <= 'Z') {
                para.append((char)(ch + 32));
            } else {
                String word = para.toString();
                int cnt = words.getOrDefault(word, 0);
                if(cnt != -1 && !word.equals("") && maxCnt < ++cnt) {
                    maxCnt = cnt;
                    result = word;
                }
                words.put(word, cnt);
                para = new StringBuilder();
            }
        }
        String word = para.toString();
        int cnt = words.getOrDefault(word, 0);
        if(word.length() > 0 && maxCnt <= cnt){
            return word;
        }
        return result;
    }
}