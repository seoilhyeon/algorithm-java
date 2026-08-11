package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No207_CourseSchedule {

    class Solution {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            for (int[] p : prerequisites) {
                adjMap.putIfAbsent(p[0], new ArrayList<>());
                adjMap.get(p[0]).add(p[1]);
            }

            boolean[] takes = new boolean[numCourses];
            boolean[] mem = new boolean[numCourses];

            for (int finish : adjMap.keySet()) {
                if (!dfs(finish, takes, mem))
                    return false;
            }
            return true;
        }

        boolean dfs(int finish, boolean[] takes, boolean[] mem) {
            if (takes[finish])
                return false;

            if (mem[finish])
                return true;

            if (adjMap.containsKey(finish)) {
                takes[finish] = true;
                for (int take : adjMap.get(finish)) {
                    if (!dfs(take, takes, mem))
                        return false;
                }
                takes[finish] = false;
                mem[finish] = true;
            }

            return true;
        }
    }
}
