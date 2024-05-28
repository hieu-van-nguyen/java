package us.inest.epi.binarytree;

import us.inest.epi.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>(){
            {
                add(root);
            }
        };
        List<Integer> result = new ArrayList<>();
        TreeNode node = null;
        while (!nextLevel.isEmpty()) {
            currentLevel = nextLevel;
            nextLevel = new LinkedList<>();
            while (!currentLevel.isEmpty()) {
                node = currentLevel.poll();

                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            result.add(node.val);
        }
        return result;
    }
}
