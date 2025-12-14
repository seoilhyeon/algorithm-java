package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39_CombinationSum {
    class Solution1 {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);

            List<List<Integer>> results = new ArrayList<>();
            backtrack(candidates, 0, target, new ArrayList<>(), results);
            return results;
        }

        private void backtrack(int[] candidates, int idx, int remain, List<Integer> path, List<List<Integer>> results) {
            if (remain == 0) {
                results.add(new ArrayList<>(path));
                return;
            }

            for (int i = idx; i < candidates.length; i++) {
                int n = candidates[i];
                if (n > remain) {
                    break;
                }

                path.add(n);
                backtrack(candidates, i, remain - n, path, results);
                path.remove(path.size() - 1);
            }
        }
    }
}
