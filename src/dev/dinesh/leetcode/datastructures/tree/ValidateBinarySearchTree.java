package dev.dinesh.leetcode.datastructures.tree;

public class ValidateBinarySearchTree {

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

    public boolean validate(TreeNode root, Integer low, Integer high) {

        if(root == null) {
            return true;
        }

        if((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }

        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

}