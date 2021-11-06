package dev.dinesh.leetcode.dailychallenge;

public class SumRootToLeafNumbers {

    int totalSum = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void calculateLeafSum(TreeNode node, int sum) {
        if(node.left == null && node.right == null) {
            this.totalSum += ((sum*10) + node.val);
        }
        if(node.left != null) {
            calculateLeafSum(node.left, ((sum*10) + node.val));
        }
        if(node.right != null) {
            calculateLeafSum(node.right, ((sum*10) + node.val));
        }
    }

    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        calculateLeafSum(root, 0);
        return this.totalSum;
    }

}