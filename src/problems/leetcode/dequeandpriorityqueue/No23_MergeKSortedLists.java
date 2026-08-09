package problems.leetcode.dequeandpriorityqueue;

import java.util.Comparator;
import java.util.PriorityQueue;

import types.leetcode.ListNode;

public class No23_MergeKSortedLists {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));

            for (ListNode list : lists) {
                while (list != null) {
                    pq.add(list);
                    list = list.next;
                }
            }

            ListNode root = new ListNode(), p = root;
            while (!pq.isEmpty()) {
                p.next = pq.poll();
                p = p.next;
            }
            p.next = null;

            return root.next;
        }
    }
}
