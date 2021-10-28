package dev.dinesh.leetcode.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {

    List<Integer> result = new ArrayList<>();

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

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return result;
        }
        if(root.left != null) {
            inorderTraversal(root.left);
        }
        result.add(root.val);
        if(root.right != null) {
            inorderTraversal(root.right);
        }
        return result;
    }

}