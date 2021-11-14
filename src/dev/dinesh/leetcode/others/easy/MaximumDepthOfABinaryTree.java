package dev.dinesh.leetcode.others.easy;

public class MaximumDepthOfABinaryTree {

    public class TreeNode {
        TreeNode left, right;
        int val;
        public TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return currentDepth(root, 1);
    }

    public int currentDepth(TreeNode node, int depth) {
        if(node.left == null && node.right == null) {
            return depth;
        } else if(node.left != null && node.right != null) {
            return Math.max(currentDepth(node.left, depth), currentDepth(node.right, depth)) + 1;
        } else if(node.left != null) {
            return currentDepth(node.left, depth) + 1;
        } else if(node.right != null) {
            return currentDepth(node.right, depth) + 1;
        }
        return 0;
    }

}

/**
 *Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * Example 2:
 *
 * Input: root = [1,null,2]
 * Output: 2
 * Example 3:
 *
 * Input: root = []
 * Output: 0
 * Example 4:
 *
 * Input: root = [0]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -100 <= Node.val <= 100
 */