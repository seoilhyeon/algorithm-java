package problems.leetcode.hashtable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class No347_TopKFrequentElements {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int n : nums) {
                freq.put(n, freq.getOrDefault(n, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                    Map.Entry.comparingByValue(Comparator.reverseOrder()));
            for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
                pq.add(e);
            }

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = pq.poll().getKey();
            }
            return ans;
        }
    }
}
