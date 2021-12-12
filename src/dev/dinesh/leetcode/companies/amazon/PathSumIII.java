package dev.dinesh.leetcode.companies.amazon;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
    int count = 0;
    List<Integer> list = new ArrayList<>();

    public class TreeNode {
        TreeNode left, right;
        int val;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

    }

    public void getSum(TreeNode root, int sum) {
        if(root == null) {
            return;
        }
        list.add(root.val);
        getSum(root.left, sum);
        getSum(root.right, sum);
        int temp = 0;
        for(int index = list.size()-1; index >= 0; index--) {
            temp += list.get(index);
            if(temp == sum) {
                count++;
            }
        }
        list.remove(list.size()-1);
    }

    public int pathSum(TreeNode root, int targetSum) {
        getSum(root, targetSum);
        return count;
    }

}