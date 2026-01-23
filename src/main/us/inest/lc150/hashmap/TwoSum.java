package us.inest.lc150.hashmap;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
                return ans;
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
