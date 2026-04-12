package us.inest.lc150.list;

import us.inest.utils.ListNode;

public class ReverseListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head;
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        ListNode tail = curr, connection = prev;
        while (right > 0) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            right--;
        }
        if (connection == null) {
            head = prev;
        } else {
            connection.next = prev;
        }
        tail.next = curr;
        return head;
    }
}
