package us.inest.epi.tree;

import us.inest.utils.TreeNode;

public class SumOfLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        //if left child is a leaf node
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }

        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
