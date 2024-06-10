package us.inest.epi.tree;

import org.junit.Test;
import us.inest.epi.utils.TreeNode;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConstructAllBSTTest {
    @Test
    public void testConstructAllBST() {
        int n = 3;
        List<TreeNode> trees = ConstructAllBST.constructAllBST(n);
        assertEquals(5, trees.size());
    }
}
