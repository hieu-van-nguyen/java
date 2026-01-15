package us.inest.lc150.array;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 */
public class RemoveDuplicateII {
    public int removeDuplicates(int[] nums) {
        int i = 1, count = 1, n = nums.length;
        while (i < n) {
            if (nums[i] == nums[i - 1]) {
                count++;
                if (count > 2) {
                    removeElement(nums, i, n);
                    n--;
                    i--;
                }
            } else {
                count = 1;
            }
            i++;
        }
        return n;
    }

    private void removeElement(int[] nums, int i, int n) {
        for (int j = i + 1; j < n; j++) {
            nums[j - 1] = nums[j];
        }
    }
}
