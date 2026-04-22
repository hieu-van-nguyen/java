package us.inest.lc150.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/subsets/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(nums, 0, new LinkedList<>(), results);
        return results;
    }

    private void backtrack(int[] nums, int index, LinkedList<Integer> subSet, List<List<Integer>> results) {
        if (index == nums.length) {
            results.add(new LinkedList<>(subSet));
            return;
        }
        subSet.add(nums[index]);
        backtrack(nums, index + 1, subSet, results);
        subSet.removeLast();
        backtrack(nums, index + 1, subSet, results);
    }
}
