package dev.dinesh.leetcode.companies.amazon;

public class SortColors {
    public void sortColors(int[] nums) {
        int[] cnt = new int[3];
        for(int index = 0; index < nums.length; index++) {
            cnt[nums[index]]++;
        }
        for(int index = 0; index < nums.length; index++) {
            if(cnt[0] > 0) {
                nums[index] = 0;
                cnt[0]--;
            } else if(cnt[1] > 0) {
                nums[index] = 1;
                cnt[1]--;
            } else {
                nums[index] = 2;
            }
        }
        return;
    }
}