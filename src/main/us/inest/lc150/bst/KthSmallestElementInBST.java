package us.inest.lc150.bst;

import us.inest.utils.TreeNode;
import java.util.Stack;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 */
public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        TreeNode p = root;
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                count++;
                if (count == k) {
                    return p.val;
                }
                p = p.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}
