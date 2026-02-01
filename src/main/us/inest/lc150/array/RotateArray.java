package us.inest.lc150.array;

/*
 * https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void rotateUsingAdditionalArray(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    private void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int tmp;
        while (i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
