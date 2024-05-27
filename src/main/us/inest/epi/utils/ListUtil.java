package us.inest.epi.utils;

import java.util.List;

public class ListUtil {
    public static void displayList(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void displayMatrix(List<List<Integer>> matrix) {
        for (int i = 0; i < matrix.size(); i++) {
            List<Integer> row = matrix.get(i);
            displayList(row);
        }
    }

    public static ListNode initLinkedList(int[] input) {
        ListNode dummyHead = new ListNode(0, null);
        ListNode current = dummyHead;
        for (int num : input) {
            current.next = new ListNode(num, null);
            current = current.next;
        }
        return dummyHead.next;
    }

    public static void displayLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            if (current.next == null) {
                //Last node
                System.out.println(current.val);
            } else {
                System.out.print(current.val + " ");
            }
            current = current.next;
        }
    }
}
