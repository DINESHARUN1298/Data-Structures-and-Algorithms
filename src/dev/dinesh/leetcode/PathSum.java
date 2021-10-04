package dev.dinesh.leetcode;

public class PathSum {

    public class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        } else if(root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        } else {
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        }
    }

}