package us.inest.lc150.prefix_sum;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class SubarraySumEqualsK {
    Map<Integer, Integer> map = new HashMap<>();
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (sum == k) count++;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
