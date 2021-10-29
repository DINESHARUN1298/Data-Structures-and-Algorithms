package dev.dinesh.leetcode.datastructures.tree;

public class MaximumDepthOfABinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return currentDepth(root, 1);
    }

    public int currentDepth(TreeNode node, int depth) {
        if(node.left == null && node.right == null) {
            return depth;
        } else if(node.left != null && node.right != null) {
            return Math.max(currentDepth(node.left, depth), currentDepth(node.right, depth)) + 1;
        } else if(node.left != null) {
            return currentDepth(node.left, depth) + 1;
        } else if(node.right != null) {
            return currentDepth(node.right, depth) + 1;
        }
        return 0;
    }

}