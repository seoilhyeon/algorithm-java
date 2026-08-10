package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class No77_Combinations {

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            backtrack(n, k, 0);
            return ans;
        }

        void backtrack(int n, int k, int start) {
            if (k == buffer.size()) {
                ans.add(new ArrayList<>(buffer));
                return;
            }

            for (int i = start + 1; i <= n - (k - buffer.size()) + 1; i++) {
                buffer.add(i);
                backtrack(n, k, i);
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
