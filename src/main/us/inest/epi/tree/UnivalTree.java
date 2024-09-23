package us.inest.epi.tree;

import us.inest.utils.TreeNode;

public class UnivalTree {
    public int countUnivalSubTrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countUnivalSubTrees(root.left);
        int right = countUnivalSubTrees(root.right);
        return isUnival(root) ? 1 + left + right : left + right;
    }

    private boolean isUnival(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalHelper(root, root.val);
    }

    private boolean isUnivalHelper(TreeNode root, int val) {
        if (root == null) {
            return true;
        }
        if (root.val == val) {
            return isUnivalHelper(root.left, val) && isUnivalHelper(root.right, val);
        }
        return false;
    }

    public int countUnivalSubTreesV2(TreeNode root) {
        return countUnivalSubTreesV2helper(root).count;
    }

    public ReturnValue countUnivalSubTreesV2helper(TreeNode root) {
        if (root == null) {
            return new ReturnValue(0, true);
        }
        ReturnValue leftResult = countUnivalSubTreesV2helper(root.left);
        ReturnValue rightResult = countUnivalSubTreesV2helper(root.right);
        int totalCount = leftResult.count + rightResult.count;
        if (leftResult.isUnival && rightResult.isUnival) {
            if (root.left != null && root.val != root.left.val) {
                return new ReturnValue(totalCount, false);
            }
            if (root.right != null && root.val != root.right.val) {
                return new ReturnValue(totalCount, false);
            }
            return new ReturnValue(totalCount + 1, true);
        }
        return new ReturnValue(totalCount, false);
    }

    private class ReturnValue {
        public ReturnValue(int count, boolean isUnival) {
            this.count = count;
            this.isUnival = isUnival;
        }

        public int count;
        public boolean isUnival;
    }
}
