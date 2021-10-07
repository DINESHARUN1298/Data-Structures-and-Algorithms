package dev.dinesh.leetcode;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int firstIndex = 0, lastIndex = height.length - 1;
        int max = Integer.MIN_VALUE;
        while(firstIndex < lastIndex) {
            int min = Math.min(height[firstIndex], height[lastIndex]);
            max = Math.max(max, min * (lastIndex - firstIndex));
            if(height[firstIndex] < height[lastIndex]) {
                firstIndex++;
            } else {
                lastIndex--;
            }
        }
        return max;
    }
}