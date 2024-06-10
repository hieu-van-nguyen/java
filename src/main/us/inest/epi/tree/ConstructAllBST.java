package us.inest.epi.tree;

import us.inest.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ConstructAllBST {
    public static List<TreeNode> constructAllBST(int n) {
        return constructAllBSTHelper(1, n);
    }

    private static List<TreeNode> constructAllBSTHelper(int low, int high) {
        List<TreeNode> trees = new ArrayList<>();
        if (low > high) {
            trees.add(null);
            return trees;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> leftChildren = constructAllBSTHelper(low, i - 1);
            List<TreeNode> rightChildren = constructAllBSTHelper(i + 1, high);
            for (TreeNode left : leftChildren) {
                for (TreeNode right : rightChildren) {
                    trees.add(new TreeNode(i, left, right));
                }
            }
        }
        return trees;
    }
}
