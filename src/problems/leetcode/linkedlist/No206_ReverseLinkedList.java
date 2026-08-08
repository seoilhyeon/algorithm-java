package problems.leetcode.linkedlist;

import types.leetcode.ListNode;

public class No206_ReverseLinkedList {

    class Solution1 {
        public ListNode reverseList(ListNode head) {
            ListNode node = head, prev = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            return prev;
        }
    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            return reverse(head, null);
        }

        ListNode reverse(ListNode node, ListNode prev) {
            if (node == null)
                return prev;

            ListNode next = node.next;
            node.next = prev;

            return reverse(next, node);
        }
    }
}
