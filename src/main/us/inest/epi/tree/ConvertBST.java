package us.inest.epi.tree;

import us.inest.utils.TreeNode;

import java.util.Stack;

public class ConvertBST {
    // https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(0);
        TreeNode prev = dummy;
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            prev.right = curr;
            curr.left = prev;
            prev = curr;
            curr = curr.right;
        }
        dummy.right.left = prev;
        prev.right = dummy.right;
        return dummy.right;
    }
}
