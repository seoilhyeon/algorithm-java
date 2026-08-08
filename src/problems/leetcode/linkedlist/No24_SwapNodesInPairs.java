package problems.leetcode.linkedlist;

import types.leetcode.ListNode;

public class No24_SwapNodesInPairs {

    class Solution1 {
        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode n = head.next, nn = head.next.next;
            n.next = head;
            head.next = swapPairs(nn);

            return n;
        }
    }

    class Solution2 {
        public ListNode swapPairs(ListNode head) {
            ListNode root = new ListNode(0, head), p = root;
            while (p != null && p.next != null && p.next.next != null) {
                ListNode n = p.next, nn = n.next;
                p.next = nn;
                n.next = nn.next;
                nn.next = n;

                p = p.next.next;
            }

            return root.next;
        }
    }
}
