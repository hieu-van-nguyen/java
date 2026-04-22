package us.inest.lc150.tree;

import us.inest.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        dfs(root, targetSum, paths, path);
        return paths;
    }

    private void dfs(TreeNode node, int targetSum, List<List<Integer>> paths, List<Integer> path) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null) {
            if (node.val == targetSum) {
                paths.add(new LinkedList<>(path));
            }
        }
        dfs(node.left, targetSum - node.val, paths, path);
        dfs(node.right, targetSum - node.val, paths, path);
        path.removeLast();
    }
}
