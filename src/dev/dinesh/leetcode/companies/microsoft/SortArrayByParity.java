package dev.dinesh.leetcode.companies.microsoft;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int ptr1 = 0, ptr2 = nums.length - 1;
        while(ptr1 < ptr2) {
            while(ptr1 < ptr2 && nums[ptr1] % 2 == 0) {
                ptr1++;
            }
            while(ptr1 < ptr2 && nums[ptr2] % 2 == 1) {
                ptr2--;
            }
            if(ptr1 < ptr2) {
                int temp = nums[ptr1];
                nums[ptr1] = nums[ptr2];
                nums[ptr2] = temp;
            }
        }
        return nums;
    }
}