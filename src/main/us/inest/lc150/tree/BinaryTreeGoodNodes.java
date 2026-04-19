package us.inest.lc150.tree;

import us.inest.utils.TreeNode;

class Pair {
    public TreeNode node;
    public int currentMax;

    public Pair(TreeNode node, int currentMax) {
        this.node = node;
        this.currentMax = currentMax;
    }
}

public class BinaryTreeGoodNodes {
    private int numOfGoodNodes = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numOfGoodNodes;
    }

    private void dfs(TreeNode root, int currentMax) {
        if (root == null) return;
        if (root.val >= currentMax) {
            numOfGoodNodes++;
        }
        dfs(root.left, Math.max(currentMax, root.val));
        dfs(root.right, Math.max(currentMax, root.val));
    }
}
