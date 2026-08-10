package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class No39_CombinationSum {

    class Solution {
        List<List<Integer>> ans;
        List<Integer> buffer;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            ans = new ArrayList<>();
            buffer = new ArrayList<>();

            backtrack(candidates, 0, target);
            return ans;
        }

        void backtrack(int[] candidates, int idx, int remain) {
            if (remain == 0) {
                ans.add(new ArrayList<>(buffer));
                return;
            }

            for (int i = idx; i < candidates.length; i++) {
                if (candidates[i] > remain)
                    continue;

                buffer.add(candidates[i]);
                backtrack(candidates, i, remain - candidates[i]);
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
