package dev.dinesh.leetcode.datastructures.tree;

public class LowestCommonAncestorOfABinarySearchTreeIterativeApproach {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        int rootVal;
        int pVal = p.val;
        int qVal = q.val;
        while(root != null) {
            rootVal = root.val;
            if(rootVal < pVal && rootVal < qVal) {
                root = root.right;
            } else if(rootVal > pVal && rootVal > qVal) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

}