package dev.dinesh.leetcode.companies.amazon;

public class MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        long[] dp = new long[N + 1];
        dp[0] = startFuel;
        for(int stationIndex = 0; stationIndex < N; stationIndex++) {
            for(int stops = stationIndex; stops >= 0; stops--) {
                if(dp[stops] >= stations[stationIndex][0]) {
                    dp[stops + 1] = Math.max(dp[stops] + (long) stations[stationIndex][1], dp[stops + 1]);
                }
            }
        }
        for(int index = 0; index <= N; index++) {
            if(dp[index] >= target) {
                return index;
            }
        }
        return -1;
    }
}