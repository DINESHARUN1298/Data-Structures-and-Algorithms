package dev.dinesh.leetcode.companies.amazon;

import javafx.util.Pair;
import java.util.LinkedList;

public class MaximumWidthOfBinaryTree {

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

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Integer maxWidth = 0;
        queue.addLast(new Pair<>(root, 0));
        while(queue.size() > 0) {
            Pair<TreeNode, Integer> head = queue.getFirst();
            Integer currLevelSize = queue.size();
            Pair<TreeNode, Integer> element = null;
            for(int index = 0; index < currLevelSize; index++) {
                element = queue.removeFirst();
                TreeNode node = element.getKey();
                if(node.left != null) {
                    queue.addLast(new Pair<>(node.left, 2*element.getValue()));
                }
                if(node.right != null) {
                    queue.addLast(new Pair<>(node.right, 2*element.getValue()+1));
                }
            }
            maxWidth = Math.max(maxWidth, element.getValue() - head.getValue() + 1);
        }
        return maxWidth;
    }

}