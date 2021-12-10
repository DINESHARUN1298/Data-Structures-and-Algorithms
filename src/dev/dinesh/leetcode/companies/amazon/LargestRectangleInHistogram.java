package dev.dinesh.leetcode.companies.amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {

        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;

        for(int index = 0; index < length; index++) {
            while((stack.peek() != -1) && (heights[stack.peek()] >= heights[index])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = index - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(index);
        }

        while(stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }

        return maxArea;

    }

}