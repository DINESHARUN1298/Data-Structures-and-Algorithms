package dev.dinesh.leetcode.datastructures.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreePreOrderTraversal {

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

    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if(root == null) {
            return output;
        }
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if(node.right != null) {
                stack.add(node.right);
            }
            if(node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

}