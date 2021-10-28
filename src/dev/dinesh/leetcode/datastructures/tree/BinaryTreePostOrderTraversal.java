package dev.dinesh.leetcode.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostOrderTraversal {

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

    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return result;
        }
        if(root.left != null) {
            postorderTraversal(root.left);
        }
        if(root.right != null) {
            postorderTraversal(root.right);
        }
        result.add(root.val);
        return result;
    }

}