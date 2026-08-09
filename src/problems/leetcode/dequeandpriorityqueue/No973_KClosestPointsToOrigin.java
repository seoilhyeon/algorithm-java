package problems.leetcode.dequeandpriorityqueue;

import java.util.PriorityQueue;

public class No973_KClosestPointsToOrigin {

    class Solution {
        public int[][] kClosest(int[][] points, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));

            for (int[] p : points) {
                pq.add(p);

                while (!pq.isEmpty() && pq.size() > k)
                    pq.poll();
            }

            return pq.stream().toArray(int[][]::new);
        }
    }
}
