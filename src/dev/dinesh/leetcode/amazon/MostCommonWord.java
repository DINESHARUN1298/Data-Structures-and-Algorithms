package dev.dinesh.leetcode.amazon;

import java.util.HashMap;
import java.util.HashSet;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedWords = new HashSet<>();
        for(String word: banned) {
            bannedWords.add(word);
        }
        HashMap<String, Integer> counter = new HashMap<>();
        for(String word: paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ")) {
            if(!bannedWords.contains(word)) {
                counter.put(word, counter.getOrDefault(word, 0) + 1);
            }
        }
        String result = "";
        for(String key: counter.keySet()) {
            if(result.equals("") || counter.get(key) > counter.get(result)) {
                result = key;
            }
        }
        return result;
    }
}