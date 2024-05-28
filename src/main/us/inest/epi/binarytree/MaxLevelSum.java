package us.inest.epi.binarytree;

import us.inest.epi.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int ans = 0, level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            level++;
            int sum = 0;
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (maxSum < sum) {
                maxSum = sum;
                ans = level;
            }
        }
        return ans;
    }
}
