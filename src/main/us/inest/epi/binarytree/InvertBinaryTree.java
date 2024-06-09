package us.inest.epi.binarytree;

import us.inest.epi.utils.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;
        root.left = invertTree(rightChild);
        root.right = invertTree(leftChild);
        return root;
    }
}
