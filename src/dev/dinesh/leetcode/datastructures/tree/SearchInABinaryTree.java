package dev.dinesh.leetcode.datastructures.tree;

public class SearchInABinaryTree {

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
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        } else {
            if(val > root.val) {
                return searchBST(root.right, val);
            } else {
                return searchBST(root.left, val);
            }
        }
    }

}