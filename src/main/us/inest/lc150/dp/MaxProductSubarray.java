package us.inest.lc150.dp;

/*
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaxProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int currentMax = nums[0];
        int currentMin = nums[0];
        int ans = currentMax;
        for (int i = 1; i < nums.length; i++) {
            int tempMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(currentMax * nums[i], currentMin * nums[i]));
            currentMax = tempMax;
            ans = Math.max(ans, currentMax);
        }
        return ans;
    }
}
