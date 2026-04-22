package us.inest.lc150.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        backtrack(candidates, 0, target, new LinkedList<>(), results);
        return results;
    }

    private void backtrack(int[] candidates, int start, int remain, LinkedList<Integer> comb, List<List<Integer>> results) {
        if (remain == 0) {
            results.add(new LinkedList<>(comb));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            comb.add(candidates[i]);
            backtrack(candidates, i, remain - candidates[i], comb, results);
            comb.removeLast();
        }
    }
}
