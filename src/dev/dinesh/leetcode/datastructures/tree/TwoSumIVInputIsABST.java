package dev.dinesh.leetcode.datastructures.tree;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputIsABST {

    Set<Integer> traversedElements = new HashSet<Integer>();

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

    public boolean findTarget(TreeNode root, int k) {

        if(root == null) {
            return false;
        }

        if(traversedElements.contains(k - root.val)) {
            return true;
        } else {
            traversedElements.add(root.val);
            return findTarget(root.left, k) || findTarget(root.right, k);
        }

    }

}