package us.inest.lc150.list;

import us.inest.utils.ListNode;

/*
 * https://leetcode.com/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            int d = sum % 10;
            carry = sum / 10;
            ListNode node = new ListNode(d);
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            curr.next = node;
            curr = curr.next;
        }
        return dummyHead.next;
    }
}
