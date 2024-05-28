package us.inest.epi.binarytree;

import us.inest.epi.utils.TreeNode;

import java.util.*;

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root == p || root == q) return root;

        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        stack.push(root);
        parent.put(root, null);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
                parent.put(current.left, current);
            }
            if (current.right != null) {
                stack.push(current.right);
                parent.put(current.right, current);
            }
        }

        Set<TreeNode> seen = new HashSet<>();
        while (p != null) {
            seen.add(p);
            p = parent.get(p);
        }
        while (!seen.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
