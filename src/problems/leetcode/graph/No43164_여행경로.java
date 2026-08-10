package problems.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class No43164_여행경로 {

    class Solution {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        Deque<String> ans = new ArrayDeque<>();

        public String[] solution(String[][] tickets) {
            for (String[] ticket : tickets) {
                graph.putIfAbsent(ticket[0], new PriorityQueue<>());
                graph.get(ticket[0]).add(ticket[1]);
            }

            dfs("ICN");
            return ans.toArray(new String[0]);
        }

        void dfs(String from) {
            PriorityQueue<String> arrivals = graph.getOrDefault(from, new PriorityQueue<>());
            while (!arrivals.isEmpty()) {
                dfs(arrivals.poll());
            }
            ans.addFirst(from);
        }
    }
}
