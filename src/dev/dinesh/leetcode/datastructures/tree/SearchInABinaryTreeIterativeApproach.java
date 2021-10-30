package dev.dinesh.leetcode.datastructures.tree;

public class SearchInABinaryTreeIterativeApproach {

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

    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null) {
            if(root.val == val) {
                return root;
            }
            root = root.val < val ? root.right : root.left;
        }
        return null;
    }

}