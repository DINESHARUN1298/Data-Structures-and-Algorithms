package dev.dinesh.leetcode.preparation.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseScheduleII {

    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;

    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();

        for(int index = 0; index < numCourses; index++) {
            this.color.put(index, WHITE);
        }
    }

    private void dfs(int node) {
        if(!this.isPossible) {
            return;
        }

        this.color.put(node, GRAY);

        for(Integer neighbour : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if(this.color.get(neighbour) == WHITE) {
                this.dfs(neighbour);
            } else if(this.color.get(neighbour) == GRAY) {
                this.isPossible = false;
            }
        }

        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        this.init(numCourses);

        for(int index = 0; index < prerequisites.length; index++) {
            int dest = prerequisites[index][0];
            int src = prerequisites[index][1];
            List<Integer> list = adjList.getOrDefault(src, new ArrayList<Integer>());
            list.add(dest);
            adjList.put(src, list);
        }

        for(int index = 0; index < numCourses; index++) {
            if(this.color.get(index) == WHITE) {
                this.dfs(index);
            }
        }

        int[] order;
        if(this.isPossible) {
            order = new int[numCourses];
            for(int index = 0; index < numCourses; index++) {
                order[index] = this.topologicalOrder.get(numCourses - index - 1);
            }
        } else {
            order = new int[0];
        }

        return order;
    }

}