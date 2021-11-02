package dev.dinesh.leetcode.amazon;

public class NumberOfProvinces {

    public void dfs(int[][] isConnected, int[] visited, int rowIndex) {
        for(int colIndex = 0; colIndex < isConnected[0].length; colIndex++) {
            if(isConnected[rowIndex][colIndex] == 1 && visited[colIndex] == 0) {
                visited[colIndex] = 1;
                dfs(isConnected, visited, colIndex);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for(int index = 0; index < isConnected.length; index++) {
            if(visited[index] == 0) {
                dfs(isConnected, visited, index);
                count++;
            }
        }
        return count;
    }

}