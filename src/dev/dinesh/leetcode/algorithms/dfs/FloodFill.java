package dev.dinesh.leetcode.algorithms.dfs;

public class FloodFill {

    public void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        if(row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != oldColor) {
            return;
        }
        image[row][col] = newColor;
        dfs(image, row, col-1, oldColor, newColor);
        dfs(image, row, col+1, oldColor, newColor);
        dfs(image, row-1, col, oldColor, newColor);
        dfs(image, row+1, col, oldColor, newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

}