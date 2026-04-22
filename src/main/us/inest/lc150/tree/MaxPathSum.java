package us.inest.lc150.tree;

import us.inest.utils.TreeNode;

/*
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class MaxPathSum {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
       if (root == null) return 0;
       int leftPath = Math.max(dfs(root.left), 0);
       int rightPath = Math.max(dfs(root.right), 0);
       maxSum = Math.max(maxSum, leftPath + root.val + rightPath);
       return Math.max(leftPath + root.val, rightPath + root.val);
    }
}
