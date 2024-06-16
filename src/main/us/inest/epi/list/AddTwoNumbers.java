package us.inest.epi.list;

import us.inest.utils.ListNode;

public class AddTwoNumbers {
    public static ListNode add_rec(ListNode l1, ListNode l2) {
        return addHelper(l1, l2, 0);
    }

    private static ListNode addHelper(ListNode l1, ListNode l2, int carry) {
        // base case
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int num1 = l1 != null ? l1.val : 0;
        int num2 = l2 != null ? l2.val : 0;
        int sum = num1 + num2 + carry;
        int digit = sum % 10;
        carry /= 10;
        ListNode node = new ListNode(digit, addHelper(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry));
        return node;
    }
}
