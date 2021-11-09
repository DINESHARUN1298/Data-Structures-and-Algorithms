package dev.dinesh.leetcode.algorithms.bfs;

public class PopulatingNextRightPointersInEachNodeWithoutQueue {

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
        Node leftmost = root;
        while(leftmost.left != null) {
            Node head = leftmost;
            while(head != null) {
                head.left.next = head.right;
                if(head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

}