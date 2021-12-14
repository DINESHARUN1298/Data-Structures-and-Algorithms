package dev.dinesh.leetcode.companies.amazon.tree;

public class SumOfNodesWithEvenValuedGrandparent {

    int sum;

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

    public int sumEvenGrandparent(TreeNode root) {
        solve(root.left, root, null);
        solve(root.right, root, null);
        return sum;
    }

    void solve(TreeNode root, TreeNode parent, TreeNode gp) {
        if(root == null) {
            return;
        }
        if(gp != null && gp.val % 2 == 0) {
            sum += root.val;
        }
        solve(root.left, root, parent);
        solve(root.right, root, parent);
    }

}