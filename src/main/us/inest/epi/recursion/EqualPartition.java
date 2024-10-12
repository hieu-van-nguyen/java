package us.inest.epi.recursion;

import java.util.HashMap;

public class EqualPartition {
    public static boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        return canPartition(nums, 0, 0, total / 2);
    }

    private static boolean canPartition(int[] nums, int index, int partial, int target) {
        if (partial == target) {
            return true;
        }

        if (partial > target || index >= nums.length) {
            return false;
        }

        return canPartition(nums, index + 1, partial, target)
                || canPartition(nums, index + 1, partial + nums[index], target);
    }

    public static boolean canPartition_DP(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % 2 != 0) {
            return false;
        }

        return canPartition_DP(nums, 0, 0, total / 2, new HashMap<String, Boolean>());
    }

    private static boolean canPartition_DP(int[] nums, int index, int partial, int target,
                                           HashMap<String, Boolean> state) {
        String currentState = index + "" + partial;
        if (state.containsKey(currentState)) {
            return state.get(currentState);
        }

        if (partial == target) {
            return true;
        }

        if (partial > target || index >= nums.length) {
            return false;
        }

        boolean foundPartition = canPartition_DP(nums, index + 1, partial, target, state)
                || canPartition_DP(nums, index + 1, partial + nums[index], target, state);
        state.put(currentState, foundPartition);
        return foundPartition;
    }
}
