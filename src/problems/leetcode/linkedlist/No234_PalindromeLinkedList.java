package problems.leetcode.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

import types.leetcode.ListNode;

public class No234_PalindromeLinkedList {
    /**
     * 1. 빠른 러너 & 느린 러너
     * 2. 스택
     */
    class Solution1 {
        public boolean isPalindrome(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            if (fast != null) {
                slow = slow.next;
            }

            ListNode rev = null;
            while (slow != null) {
                ListNode next = slow.next;
                slow.next = rev;
                rev = slow;
                slow = next;
            }

            while (rev != null) {
                if (rev.val != head.val) {
                    return false;
                }
                rev = rev.next;
                head = head.next;
            }

            return true;
        }
    }

    class Solution2 {
        public boolean isPalindrome(ListNode head) {
            Deque<Integer> stack = new ArrayDeque<>();
            ListNode p = head;

            while (p != null) {
                stack.push(p.val);
                p = p.next;
            }

            p = head;
            while (!stack.isEmpty()) {
                if (stack.pop() != p.val) {
                    return false;
                }
                p = p.next;
            }

            return true;
        }
    }
}
