package dev.dinesh.leetcode.companies.amazon.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

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

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> output = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return output;
        }

        TreeNode current = root;

        while(current != null || !stack.isEmpty()) {

            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            output.add(current.val);
            current = current.right;

        }

        return output;

    }
    
}