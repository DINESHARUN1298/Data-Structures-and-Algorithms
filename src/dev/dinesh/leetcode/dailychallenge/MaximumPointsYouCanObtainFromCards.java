package dev.dinesh.leetcode.dailychallenge;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length, maxPoints = 0;
        int[] frontSet = new int[k+1];
        int[] rearSet = new int[k+1];

        for(int index = 0; index < k; index++) {
            frontSet[index + 1] = cardPoints[index] + frontSet[index];
            rearSet[index + 1] = cardPoints[n - index - 1] + rearSet[index];
        }

        for(int index = 0; index <= k; index++) {
            maxPoints = Math.max(maxPoints, frontSet[index] + rearSet[k - index]);
        }

        return maxPoints;

    }
}