package us.inest.lc150.list;
import us.inest.utils.ListNode;

/*
 * https://leetcode.com/problems/linked-list-cycle/?envType=study-plan-v2&envId=top-interview-150
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
