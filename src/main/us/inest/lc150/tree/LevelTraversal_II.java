package us.inest.lc150.tree;

import us.inest.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */
public class LevelTraversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(root, 0, results);
        return results;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> results) {
        if (root == null) return;
        if (level == results.size()) {
            results.addFirst(new LinkedList<>());
        }
        results.get(results.size() - 1 - level).add(root.val);
        dfs(root.left, level + 1, results);
        dfs(root.right, level + 1, results);
    }
}
