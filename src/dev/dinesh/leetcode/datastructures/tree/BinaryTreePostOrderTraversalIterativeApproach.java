package dev.dinesh.leetcode.datastructures.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversalIterativeApproach {

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
        List<Integer> reversedResult = new ArrayList<>();
        List<Integer> actualResult = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) {
            return reversedResult;
        }

        stack.add(root);

        while(!stack.isEmpty()){
            TreeNode current = stack.pop();
            reversedResult.add(current.val);
            if(current.left != null) {
                stack.add(current.left);
            }
            if(current.right != null) {
                stack.add(current.right);
            }
        }

        int cnt = reversedResult.size();
        while(cnt > 0) {
            actualResult.add(reversedResult.get(cnt-1));
            cnt--;
        }

        return actualResult;
    }

}