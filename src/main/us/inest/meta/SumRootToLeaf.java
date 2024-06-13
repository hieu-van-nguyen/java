package us.inest.meta;

import us.inest.utils.TreeNode;

public class SumRootToLeaf {
    Integer sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sumNumbers(root, 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int currentNum) {
        if (root == null) return;
        currentNum = currentNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += currentNum;
        }
        sumNumbers(root.left, currentNum);
        sumNumbers(root.right, currentNum);
    }
}
