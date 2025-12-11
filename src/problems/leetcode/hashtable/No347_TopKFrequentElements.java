package problems.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class No347_TopKFrequentElements {
    class Solution1 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int n : nums) {
                counter.put(n, counter.getOrDefault(n, 0) + 1);
            }

            Map<Integer, List<Integer>> buckets = new HashMap<>();
            for (int key : counter.keySet()) {
                int value = counter.get(key);
                buckets.putIfAbsent(value, new ArrayList<>());
                buckets.get(value).add(key);
            }

            int[] result = new int[k];
            int idx = 0;
            for (int i = nums.length; i > 0 && idx < k; i--) {
                for (int n : buckets.getOrDefault(i, new ArrayList<>())) {
                    result[idx++] = n;
                    if (idx == k) {
                        break;
                    }
                }
            }
            return result;
        }
    }

    class Solution2 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int n : nums) {
                counter.put(n, counter.getOrDefault(n, 0) + 1);
            }

            List<Integer>[] buckets = new List[nums.length + 1];
            for (int key : counter.keySet()) {
                int value = counter.get(key);
                if (buckets[value] == null) {
                    buckets[value] = new ArrayList<>();
                }
                buckets[value].add(key);
            }

            int[] result = new int[k];
            int idx = 0;
            for (int i = nums.length; i > 0 && idx < k; i--) {
                if (buckets[i] == null) {
                    continue;
                }
                for (int n : buckets[i]) {
                    result[idx++] = n;
                    if (idx == k) {
                        break;
                    }
                }
            }
            return result;
        }
    }

    class Solution3 {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int n : nums) {
                counter.put(n, counter.getOrDefault(n, 0) + 1);
            }

            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                    Map.Entry.comparingByValue(Comparator.reverseOrder()));
            for (Map.Entry<Integer, Integer> e : counter.entrySet()) {
                pq.add(e);
            }

            int[] result = new int[k];
            for (int i = 0; i < result.length; i++) {
                result[i] = pq.remove().getKey();
            }

            return result;
        }
    }
}
