package problems.programmers.dequeandpriorityqueue;

import java.util.PriorityQueue;

public class No42626_더맵게 {
    class Solution1 {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int s : scoville) {
                pq.add(s);
            }
            while (pq.size() > 1 && pq.peek() < K) {
                int first = pq.remove(), second = pq.remove();
                pq.add(first + 2 * second);
                answer++;
            }

            return pq.peek() >= K ? answer : -1;
        }
    }
}
