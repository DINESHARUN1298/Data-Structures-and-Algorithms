package dev.dinesh.leetcode.companies.amazon.tree;

public class LargestBSTSubtreeOptimized {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class NodeValue {
        public int maxNode, minNode, maxSize;
        public NodeValue(int minNode, int maxNode, int maxSize) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.maxSize = maxSize;
        }
    };

    class Solution {

        public NodeValue largestBSTSubtreeHelper(TreeNode root) {
            if(root == null) {
                return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }
            NodeValue left = largestBSTSubtreeHelper(root.left);
            NodeValue right = largestBSTSubtreeHelper(root.right);
            if(left.maxNode < root.val && right.minNode > root.val) {
                return new NodeValue(Math.min(left.minNode, root.val), Math.max(right.maxNode, root.val) , left.maxSize + right.maxSize + 1);
            }
            return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
        }

        public int LargestBSTSubtreeOptimized(TreeNode root) {
            return largestBSTSubtreeHelper(root).maxSize;
        }

    }

}