package problems.leetcode.linkedlist;

import types.leetcode.ListNode;

public class No328_OddEvenLinkedList {
    class Solution1 {
        public ListNode oddEvenList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode oddRoot = new ListNode(0, head), evenRoot = new ListNode(0, head.next);
            ListNode odd = head, even = head.next;
            while (odd.next != null && odd.next.next != null) {
                odd.next = even.next;
                even.next = odd.next.next;

                odd = odd.next;
                even = even.next;
            }

            odd.next = evenRoot.next;
            return oddRoot.next;
        }
    }
}
