package problems.leetcode.linkedlist;

import types.leetcode.ListNode;

public class No21_MergeTwoSortedLists {

    class Solution1 {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode root = new ListNode(), p = root;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    p.next = list1;
                    list1 = list1.next;
                } else {
                    p.next = list2;
                    list2 = list2.next;
                }
                p = p.next;
            }
            p.next = (list1 != null) ? list1 : list2;

            return root.next;
        }
    }

    class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null)
                return list2;

            if (list2 == null)
                return list1;

            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            }

            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
