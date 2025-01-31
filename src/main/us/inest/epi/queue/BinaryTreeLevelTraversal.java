package us.inest.epi.queue;

import us.inest.utils.TreeNode;

import java.util.*;

public class BinaryTreeLevelTraversal {
    public List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        q.add(root);
        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                level.add(current.val);
                if (current.left != null) {
                    q.add(current.left);
                }
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
