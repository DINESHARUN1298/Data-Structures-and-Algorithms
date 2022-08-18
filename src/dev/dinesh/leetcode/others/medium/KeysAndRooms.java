package dev.dinesh.leetcode.others.medium;

import java.util.List;
import java.util.Stack;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        while(!stack.isEmpty()) {
            int current = stack.pop();
            for(int room : rooms.get(current)) {
                if(!visited[room]) {
                    visited[room] = true;
                    stack.push(room);
                }
            }
        }

        for(boolean room : visited) {
            if(!room) {
                return false;
            }
        }

        return true;

    }
}