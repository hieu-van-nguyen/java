package us.inest.epi.list;

import us.inest.epi.utils.ListNode;

import java.util.Stack;

public class MaxiumTwinSum {
    public static int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<>();
        int max = Integer.MIN_VALUE;
        ListNode p = head;
        while (p != null) {
            st.push(p.val);
            p = p.next;
        }
        int size = st.size();
        p = head;
        for (int i = 0; i < size / 2; i++) {
            max = Math.max(max, p.val + st.pop());
            p = p.next;
        }
        return max;
    }
}
