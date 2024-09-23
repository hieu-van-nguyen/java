package us.inest.epi.tree;

import org.junit.Test;
import us.inest.utils.TreeNode;
import us.inest.utils.TreeUtil;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class TreeUtilTest {
    @Test
    public void testInsert() {
        TreeNode root = null;
        root = TreeUtil.initBST(new int[] { 3, 2, 1, 4, 5 });
        List<Integer> result = TreeUtil.inOrder(root);
        assertNotNull(result);
    }
}
