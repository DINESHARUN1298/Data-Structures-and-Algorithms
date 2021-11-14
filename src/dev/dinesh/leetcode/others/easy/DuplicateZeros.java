package dev.dinesh.leetcode.others.easy;

public class DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int length = arr.length, zeroCnt = 0;
        for(int val: arr) {
            if(val == 0){
                zeroCnt++;
            }
        }
        for(int i = length - 1, j = length + zeroCnt - 1; i < j; --i,--j) {
            if(j < length) {
                arr[j] = arr[i];
            }
            if(arr[i] == 0 && --j < length) {
                arr[j] = arr[i];
            }
        }
    }
}

/**
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written. Do the above modifications to the input array in place and do not return anything.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,0,2,3,0,4,5,0]
 * Output: [1,0,0,2,3,0,0,4]
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 *
 * Input: arr = [1,2,3]
 * Output: [1,2,3]
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 104
 * 0 <= arr[i] <= 9
 */