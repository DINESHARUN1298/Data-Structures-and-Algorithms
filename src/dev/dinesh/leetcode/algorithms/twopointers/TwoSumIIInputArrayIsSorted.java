package dev.dinesh.leetcode.algorithms.twopointers;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0, ptr2 = numbers.length - 1;
        while(ptr1 < ptr2) {
            if(numbers[ptr2] < target - numbers[ptr1]) {
                ptr1++;
            } else if(numbers[ptr2] > target - numbers[ptr1]) {
                ptr2--;
            } else {
                return new int[]{++ptr1, ++ptr2};
            }
        }
        return null;
    }
}