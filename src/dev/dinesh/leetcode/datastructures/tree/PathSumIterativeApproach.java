package dev.dinesh.leetcode.datastructures.tree;

import java.util.LinkedList;

public class PathSumIterativeApproach {

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

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) {
            return false;
        }

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        nodeStack.add(root);
        sumStack.add(targetSum - root.val);

        TreeNode current;
        int currSum;

        while(!nodeStack.isEmpty()){

            current = nodeStack.pollLast();
            currSum = sumStack.pollLast();

            if(current.left == null && current.right == null && currSum == 0) {
                return true;
            }

            if(current.right != null) {
                nodeStack.add(current.right);
                sumStack.add(currSum - current.right.val);
            }

            if(current.left != null) {
                nodeStack.add(current.left);
                sumStack.add(currSum - current.left.val);
            }
        }
        return false;
    }

}