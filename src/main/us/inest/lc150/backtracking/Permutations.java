package us.inest.lc150.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 8 https://leetcode.com/problems/permutations/
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, new boolean[nums.length], new LinkedList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, int index, boolean[] used, LinkedList<Integer> partial, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new LinkedList<>(partial));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                partial.add(nums[i]);
                backtrack(nums, index + 1, used, partial, results);
                used[i] = false;
                partial.removeLast();
            }
        }
    }
}
