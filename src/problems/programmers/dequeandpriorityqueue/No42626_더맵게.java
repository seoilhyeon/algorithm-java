package problems.programmers.dequeandpriorityqueue;

import java.util.PriorityQueue;

public class No42626_더맵게 {

    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int s : scoville)
                pq.add(s);

            int answer = 0;
            while (pq.size() > 1 && pq.peek() < K) {
                int s = pq.poll() + pq.poll() * 2;
                pq.add(s);
                answer++;
            }

            return pq.size() < 1 || pq.peek() < K ? -1 : answer;
        }
    }
}
