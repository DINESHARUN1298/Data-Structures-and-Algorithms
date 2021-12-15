package dev.dinesh.leetcode.companies.amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> nextGreaterElementMap = new HashMap<>();
        for(int index = 0; index < nums2.length; index++) {
            while(!stack.isEmpty() && stack.peek() < nums2[index]) {
                nextGreaterElementMap.put(stack.pop(), nums2[index]);
            }
            stack.push(nums2[index]);
        }
        System.out.println(nextGreaterElementMap);
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        for(int index = 0; index < nums1.length; index++) {
            if(nextGreaterElementMap.containsKey(nums1[index])) {
                result[index] = nextGreaterElementMap.get(nums1[index]);
            }
        }
        return result;
    }
}
