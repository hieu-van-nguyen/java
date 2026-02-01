package us.inest.lc150.array;

/*
 * https://leetcode.com/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int ans = 0, n = nums.length;
        int currentEnd = 0, currentMaxReach = 0;
        for (int i = 0; i < n - 1; i++) {
            currentMaxReach = Math.max(currentMaxReach, i + nums[i]);
            if (i == currentEnd) {
                ans++;
                currentEnd = currentMaxReach;
            }
        }
        return ans;
    }
}
