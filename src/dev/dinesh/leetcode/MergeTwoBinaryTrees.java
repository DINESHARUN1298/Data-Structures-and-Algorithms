package dev.dinesh.leetcode;

public class MergeTwoBinaryTrees {

    public class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        } else if(root1 == null && root2 != null) {
            return root2;
        } else if(root1 != null && root2 == null) {
            return root1;
        }
        TreeNode sum = new TreeNode(root1.val + root2.val);
        sum.left = mergeTrees(root1.left, root2.left);
        sum.right = mergeTrees(root1.right, root2.right);
        return sum;
    }

}