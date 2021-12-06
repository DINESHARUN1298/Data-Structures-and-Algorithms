package dev.dinesh.leetcode.companies.amazon.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {

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

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> actualResult = new LinkedList<>();
        List<Integer> reversedTraversal = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return actualResult;
        }

        stack.push(root);

        while(!stack.isEmpty()) {

            TreeNode current = stack.pop();
            reversedTraversal.add(current.val);

            if(current.left != null) {
                stack.push(current.left);
            }

            if(current.right != null) {
                stack.push(current.right);
            }

        }

        int cnt = reversedTraversal.size() - 1;

        while(cnt >= 0) {
            actualResult.add(reversedTraversal.get(cnt));
            cnt--;
        }

        return actualResult;


    }

}