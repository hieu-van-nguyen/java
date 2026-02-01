package us.inest.lc150.array;

/*
 * https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i <= maxReach && maxReach < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return maxReach >= nums.length - 1;
    }
}
