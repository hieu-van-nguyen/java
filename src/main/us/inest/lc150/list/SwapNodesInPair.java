package us.inest.lc150.list;

import us.inest.utils.ListNode;

/*
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 */
public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(head.next.next);
        newHead.next = head;
        return newHead;
    }
}
