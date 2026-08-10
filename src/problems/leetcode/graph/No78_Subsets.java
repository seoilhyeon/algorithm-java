package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class No78_Subsets {

    class Solution {
        List<List<Integer>> ans;
        List<Integer> buffer;

        public List<List<Integer>> subsets(int[] nums) {
            ans = new ArrayList<>();
            buffer = new ArrayList<>();

            backtrack(nums, 0, 0);
            return ans;
        }

        void backtrack(int[] nums, int s, int d) {
            ans.add(new ArrayList<>(buffer));

            for (int i = s; i < nums.length; i++) {
                buffer.add(nums[i]);
                backtrack(nums, i + 1, d + 1);
                buffer.remove(buffer.size() - 1);
            }
        }
    }
}
