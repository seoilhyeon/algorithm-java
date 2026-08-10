package problems.leetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class No332_ReconstructItinerary {

    class Solution1 {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        Deque<String> ans = new ArrayDeque<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                graph.get(ticket.get(0)).add(ticket.get(1));
            }

            dfs("JFK");
            return new ArrayList<>(ans);
        }

        void dfs(String from) {
            PriorityQueue<String> arrivals = graph.getOrDefault(from, new PriorityQueue<>());
            while (!arrivals.isEmpty()) {
                dfs(arrivals.poll());
            }
            ans.addFirst(from);
        }
    }

    class Solution {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        Deque<String> ans = new ArrayDeque<>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                graph.get(ticket.get(0)).add(ticket.get(1));
            }

            Deque<String> dq = new ArrayDeque<>();
            dq.addFirst("JFK");
            while (!dq.isEmpty()) {
                while (graph.containsKey(dq.peekFirst()) && !graph.get(dq.peekFirst()).isEmpty()) {
                    dq.addFirst(graph.get(dq.peekFirst()).poll());
                }
                ans.addFirst(dq.pollFirst());
            }

            return new ArrayList<>(ans);
        }
    }
}
