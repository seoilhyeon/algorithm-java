package problems.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class No332_ReconstructItinerary {
    class Solution1 {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

            for (List<String> ticket : tickets) {
                fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                fromToMap.get(ticket.get(0)).add(ticket.get(1));
            }

            List<String> path = new LinkedList<>();
            dfs(fromToMap, path, "JFK");

            return path;
        }

        private void dfs(Map<String, PriorityQueue<String>> fromToMap, List<String> path, String from) {
            while (fromToMap.containsKey(from) && !fromToMap.get(from).isEmpty()) {
                String to = fromToMap.get(from).poll();
                dfs(fromToMap, path, to);
            }

            path.add(0, from);
        }
    }

    class Solution2 {
        public List<String> findItinerary(List<List<String>> tickets) {
            Map<String, PriorityQueue<String>> fromToMap = new HashMap<>();

            for (List<String> ticket : tickets) {
                fromToMap.putIfAbsent(ticket.get(0), new PriorityQueue<>());
                fromToMap.get(ticket.get(0)).add(ticket.get(1));
            }

            Deque<String> stack = new ArrayDeque<>();
            List<String> path = new LinkedList<>();
            stack.add("JFK");
            while (!stack.isEmpty()) {
                while (fromToMap.containsKey(stack.peek()) && !fromToMap.get(stack.peek()).isEmpty()) {
                    stack.push(fromToMap.get(stack.peek()).poll());
                }
                path.add(0, stack.pop());
            }

            return path;
        }
    }
}
