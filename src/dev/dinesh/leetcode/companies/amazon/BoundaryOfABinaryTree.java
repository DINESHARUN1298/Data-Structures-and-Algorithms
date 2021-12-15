package dev.dinesh.leetcode.companies.amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfABinaryTree {

    public class TreeNode {
        TreeNode left, right;
        int val;
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

    public boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    public void addLeaves(ArrayList result, TreeNode root) {
        if (isLeaf(root)) {
            result.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(result, root.left);
            }
            if (root.right != null) {
                addLeaves(result, root.right);
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        // Base Condition - root is null
        if (root == null) {
            return result;
        }

        if (!isLeaf(root)) {
            result.add(root.val);
        }

        TreeNode leftNode = root.left;

        // Traverse left tree of root, if no left child but right child traverse by it
        while (leftNode != null) {
            if (!isLeaf(leftNode)) {
                result.add(leftNode.val);
            }
            if (leftNode.left != null) {
                leftNode = leftNode.left;
            } else {
                leftNode = leftNode.right;
            }
        }

        // Add Leaves
        addLeaves(result, root);

        Stack<Integer> stack = new Stack<>();
        TreeNode rightNode = root.right;
        while (rightNode != null) {
            if (!isLeaf(rightNode)) {
                stack.push(rightNode.val);
            }
            if (rightNode.right != null) {
                rightNode = rightNode.right;
            } else {
                rightNode = rightNode.left;
            }
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;

    }

}