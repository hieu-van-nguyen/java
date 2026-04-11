package us.inest.lc150.fast_slow_pointers;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        int head = nums[0];
        while (head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return head;
    }
}
