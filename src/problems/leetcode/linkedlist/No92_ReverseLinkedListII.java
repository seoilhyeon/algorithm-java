package problems.leetcode.linkedlist;

import types.leetcode.ListNode;

public class No92_ReverseLinkedListII {

    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode root = new ListNode(0, head), node = head, start = root;
            for (int i = 1; i < left; i++) {
                start = node;
                node = node.next;
            }

            ListNode next = null, prev = null, last = node;
            for (int i = left; i <= right; i++) {
                next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            last.next = node;
            start.next = prev;

            return root.next;
        }
    }
}
