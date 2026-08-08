package problems.leetcode.linkedlist;

import types.leetcode.ListNode;

public class No234_PalindromeLinkedList {

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode node = slow, prev = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            ListNode p = head, q = prev;
            while (q != null) {
                if (p.val != q.val)
                    return false;

                p = p.next;
                q = q.next;
            }

            return true;
        }
    }
}
