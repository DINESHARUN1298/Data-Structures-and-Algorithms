package dev.dinesh.stub;

class Solution {
    public static int getMedian(int arr1[], int arr2[]) {
        int n = arr1.length;
        int index1 = 0, index2 = 0, mergeIndex = 0;
        int[] mergedArr = new int[2 * n];
        int medianIndex2 = n;
        while(index1 < n && index2 < n) {
            if(arr1[index1] <= arr2[index2]) {
                mergedArr[mergeIndex++] = arr1[index1++];
            } else {
                mergedArr[mergeIndex++] = arr2[index2++];
            }
            if(mergeIndex-1 == medianIndex2) {
                return (mergedArr[medianIndex2-1] + mergedArr[medianIndex2])/2;
            }
        }
        while(index1 < n) {
            mergedArr[mergeIndex++] = arr1[index1++];
        }
        while(index2 < n) {
            mergedArr[mergeIndex++] = arr2[index2++];
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr1[] = {1, 12, 15, 26, 38};
        int arr2[] = {2, 13, 17, 30, 45};
        System.out.println(getMedian(arr1, arr2));
    }
}