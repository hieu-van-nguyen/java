package us.inest.lc150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/subsets-ii/
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, subsets, new LinkedList<>(), 0);
        return subsets;
    }

    private void backtrack(int[] nums, List<List<Integer>> subsets, LinkedList<Integer> subset, int index) {
        subsets.add(new LinkedList<>(subset));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            subset.add(nums[i]);
            backtrack(nums, subsets, subset, i + 1);
            subset.removeLast();
        }
    }
}
