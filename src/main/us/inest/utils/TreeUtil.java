package us.inest.utils;

public class TreeUtil {
    /*
     * initialize a BST from an input array
     */
    public static TreeNode initBST(int[] arr) {
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insertBST(root, arr[i]);
        }
        return root;
    }

    public static TreeNode insertBST(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value, null, null);
        }
        if (value < root.val) {
            root.left = insertBST(root.left, value);
        } else {
            root.right = insertBST(root.right, value);
        }
        return root;
    }
}
