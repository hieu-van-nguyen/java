package us.inest.epi.list;

import us.inest.epi.utils.ListNode;
import us.inest.epi.utils.ListUtil;

public class MergeSortedLists {
    public static ListNode<Integer> mergeTwoSortedList(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> current = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
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
        ListNode<Integer> l1 = ListUtil.initLinkedList(new int[] {1, 3, 5, 7});
        ListUtil.displayLinkedList(l1);

        ListNode<Integer> l2 = ListUtil.initLinkedList(new int[] {2, 4, 6, 8, 10});
        ListUtil.displayLinkedList(l2);

        ListNode<Integer> mergedList = mergeTwoSortedList(l1, l2);
        ListUtil.displayLinkedList(mergedList);
    }
}
