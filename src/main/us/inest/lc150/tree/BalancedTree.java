package us.inest.lc150.tree;

import us.inest.utils.TreeNode;

class StatusAndHeight {
    int height;
    boolean isBalanced;
    public StatusAndHeight(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}

public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        return isBalancedHelper(root).isBalanced;
    }

    private StatusAndHeight isBalancedHelper(TreeNode root) {
        if (root == null) {
            return new StatusAndHeight(0, true);
        }
        StatusAndHeight leftResult = isBalancedHelper(root.left);
        if (!leftResult.isBalanced) {
            return new StatusAndHeight(-1, false);
        }
        StatusAndHeight rightResult = isBalancedHelper(root.right);
        if (!rightResult.isBalanced) {
            return new StatusAndHeight(-1, false);
        }
        if (Math.abs(leftResult.height - rightResult.height) > 1) {
            return new StatusAndHeight(-1, false);
        }
        return new StatusAndHeight(1 + Math.max(leftResult.height, rightResult.height), true);
    }
}
