package dev.dinesh.leetcode.companies.amazon.tree;

public class LargestBSTSubtree {

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

    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        int leftMax = findMax(root.left);
        if(leftMax >= root.val) {
            return false;
        }
        int rightMin = findMin(root.right);
        if(rightMin <= root.val) {
            return false;
        }
        if(isValidBST(root.left) && isValidBST(root.right)) {
            return true;
        }
        return false;
    }

    public int findMax(TreeNode root) {
        if(root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(Math.max(findMax(root.left), root.val), findMax(root.right));
    }

    public int findMin(TreeNode root) {
        if(root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(Math.min(findMin(root.left), root.val), findMin(root.right));
    }

    public int largestBSTSubtree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(isValidBST(root)) {
            return countNodes(root);
        }
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

}