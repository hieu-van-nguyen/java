package us.inest.epi.list;

import us.inest.utils.ListNode;
import us.inest.utils.ListUtil;

public class MergeSortedLists {
    public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0, null);
        ListNode current = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        current.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListUtil.initLinkedList(new int[] {1, 3, 5, 7});
        ListUtil.displayLinkedList(l1);

        ListNode l2 = ListUtil.initLinkedList(new int[] {2, 4, 6, 8, 10});
        ListUtil.displayLinkedList(l2);

        ListNode mergedList = mergeTwoSortedList(l1, l2);
        ListUtil.displayLinkedList(mergedList);
    }
}
