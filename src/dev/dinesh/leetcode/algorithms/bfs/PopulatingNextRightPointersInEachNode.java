package dev.dinesh.leetcode.algorithms.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
        public Node() {}
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    };

    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            for(int index = 0; index < queueSize; index++) {
                Node currentNode = queue.poll();
                if(index < queueSize-1) {
                    currentNode.next = queue.peek();
                }
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return root;
    }

}