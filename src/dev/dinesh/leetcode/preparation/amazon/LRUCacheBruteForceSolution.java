package dev.dinesh.leetcode.preparation.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LRUCacheBruteForceSolution {
    int capacity = -1;
    HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
    int leastRecentKey = -1;

    public LRUCacheBruteForceSolution(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(hashMap.containsKey(key)) {
            if(hashMap.get(key).get(1) != 1) {
                resetPriority(key);
            }
            System.out.println("Status after get for "+ key +  ": " + hashMap.get(key).get(0) + hashMap);
            return hashMap.get(key).get(0);
        } else {
            System.out.println("Status after get for "+ key +  ": -1" + hashMap);
            return -1;
        }
    }

    public void put(int key, int value) {
        int priority = -1;
        if(!hashMap.containsKey(key) && hashMap.size() == capacity) {
            hashMap.remove(getLeastRecentKey());
        }
        if(!hashMap.containsKey(key)) {
            List<Integer> currList = new ArrayList<Integer>();
            currList.add(value);
            currList.add(-1);
            hashMap.put(key,currList);
        } else {
            priority = hashMap.get(key).get(1);
            List<Integer> currList = new ArrayList<Integer>();
            currList.add(value);
            currList.add(hashMap.get(key).get(1));
            hashMap.put(key,currList);
        }
        if(priority != 1) {
            resetPriority(key);
        }
        System.out.println("Status after put: " + hashMap);
    }

    public void resetPriority(int key) {
        int oldKeyPriority = hashMap.get(key).get(1);
        System.out.println("Key: " + key + " Old Key Priority: " + oldKeyPriority);
        List<Integer> list = new ArrayList<Integer>();
        list.add(hashMap.get(key).get(0));
        list.add(1);
        hashMap.put(key,list);
        for(int currKey : hashMap.keySet()) {
            if(currKey == key) {
                continue;
            }
            List<Integer> currList = hashMap.get(currKey);
            int priority = currList.get(1);
            if(priority < oldKeyPriority || oldKeyPriority == -1) {
                currList.remove(1);
                currList.add(priority+1);
                hashMap.put(currKey, currList);
            } else {
                currList.remove(1);
                currList.add(priority);
                hashMap.put(currKey, currList);
            }
        }
    }

    int getLeastRecentKey() {
        if(capacity == hashMap.size()) {
            if(leastRecentKey == -1) {
                for(int currKey : hashMap.keySet()) {
                    List<Integer> currList = hashMap.get(currKey);
                    int priority = currList.get(1);
                    if(priority == capacity) {
                        return currKey;
                    }
                }
            }
        }
        return leastRecentKey;
    }

}