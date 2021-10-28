package dev.dinesh.leetcode.datastructures.stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    Stack<Integer> stack = new Stack<>();

    public ImplementQueueUsingStacks() {
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        return stack.remove(0);
    }

    public int peek() {
        return stack.get(0);
    }

    public boolean empty() {
        return stack.isEmpty();
    }

}