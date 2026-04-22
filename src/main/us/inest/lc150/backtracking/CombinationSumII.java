package us.inest.lc150.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        doCombine(candidates, target, 0, new LinkedList<>(), results);
        return results;
    }

    public void doCombine(int[] candidates, int remaining, int start, LinkedList<Integer> comb, List<List<Integer>> results) {
        if (remaining == 0) {
            results.add(new LinkedList<>(comb));
            return;
        }
        if (remaining < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            comb.add(candidates[i]);
            doCombine(candidates, remaining - candidates[i], i + 1, comb, results);
            comb.removeLast();
        }
    }
}
