package dev.dinesh.leetcode.dailychallenge;

import dev.dinesh.leetcode.algorithms.twopointers.RemoveNthNodeFromTheEndOfList;

public class SumOfLeftLeaves {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return processSubTree(root, false);
    }

    public int processSubTree(TreeNode node, boolean isLeftChild) {

        if (node.left == null && node.right == null) {
            return isLeftChild ? node.val : 0;
        }

        int total = 0;

        if (node.left != null) {
            total += processSubTree(node.left, true);
        }

        if (node.right != null) {
            total += processSubTree(node.right, false);
        }

        return total;

    }

}