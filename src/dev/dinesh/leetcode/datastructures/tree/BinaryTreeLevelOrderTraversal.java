package dev.dinesh.leetcode.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

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

    public void helper(TreeNode node, int level) {

        if(levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }

        levels.get(level).add(node.val);

        if(node.left != null) {
            helper(node.left, level+1);
        }

        if(node.right != null) {
            helper(node.right, level+1);
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        if(root == null) {
            return levels;
        }

        helper(root, 0);
        return levels;

    }

}