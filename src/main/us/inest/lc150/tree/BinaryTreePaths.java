package us.inest.lc150.tree;

import us.inest.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/binary-tree-paths/description/
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        if (root == null) return paths;
        nodeStack.add(root);
        pathStack.add(String.valueOf(root.val));
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            String path = pathStack.pop();
            if (node.left == null && node.right == null) {
                paths.add(path);
            } else {
                if (node.right != null) {
                    nodeStack.push(node.right);
                    pathStack.push(path + "->" + String.valueOf(node.right.val));
                }
                if (node.left != null) {
                    nodeStack.push(node.left);
                    pathStack.push(path + "->" + String.valueOf(node.left.val));
                }
            }
        }
        return paths;
    }
}
