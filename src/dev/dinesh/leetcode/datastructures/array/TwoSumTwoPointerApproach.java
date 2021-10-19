package dev.dinesh.leetcode.datastructures.array;

public class TwoSumTwoPointerApproach {
    public int[] twoSum(int[] numbers, int target) {
        int ptr1 = 0, ptr2 = numbers.length-1;
        for(; ptr1 < ptr2; ) {
            int currSum = numbers[ptr1] + numbers[ptr2];
            if(currSum == target) {
                return new int[] {++ptr1, ++ptr2};
            } else if(currSum > target) {
                --ptr2;
            } else {
                ++ptr1;
            }
        }
        return null;
    }
}