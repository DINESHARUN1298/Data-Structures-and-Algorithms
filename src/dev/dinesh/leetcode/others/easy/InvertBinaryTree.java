package dev.dinesh.leetcode.others.easy;

public class InvertBinaryTree {

    public class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode() {}
    }

    TreeNode temp = null;

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}