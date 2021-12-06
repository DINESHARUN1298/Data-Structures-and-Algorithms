package dev.dinesh.leetcode.companies.amazon.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

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

    List<List<Integer>> output = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {

        if(output.size() == level) {
            output.add(level, new ArrayList<Integer>());
        }

        output.get(level).add(node.val);

        if(node.left != null) {
            helper(node.left, level+1);
        }

        if(node.right != null) {
            helper(node.right, level+1);
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) {
            return output;
        }

        helper(root, 0);
        return output;

    }

}