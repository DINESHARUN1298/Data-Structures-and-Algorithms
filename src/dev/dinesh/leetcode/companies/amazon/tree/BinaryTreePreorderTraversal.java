package dev.dinesh.leetcode.companies.amazon.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {

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

    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> output = new LinkedList<>();

        if(root == null) {
            return output;
        }

        stack.add(root);

        while(!stack.isEmpty()) {

            TreeNode currentNode = stack.pop();
            output.add(currentNode.val);

            if(currentNode.right != null) {
                stack.add(currentNode.right);
            }

            if(currentNode.left != null) {
                stack.add(currentNode.left);
            }

        }

        return output;

    }

}