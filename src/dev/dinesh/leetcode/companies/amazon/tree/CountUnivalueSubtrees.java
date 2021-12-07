package dev.dinesh.leetcode.companies.amazon.tree;

public class CountUnivalueSubtrees {

    int count = 0;

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

    boolean isValidPart(TreeNode node, int val) {

        if(node == null) {
            return true;
        }

        if(!isValidPart(node.left, node.val) | !isValidPart(node.right, node.val)) {
            return false;
        }

        count++;

        return node.val == val;

    }

    public int countUnivalueSubtrees(TreeNode root) {

        if(root == null) {
            return 0;
        }

        isValidPart(root, 0);

        return count;

    }

}