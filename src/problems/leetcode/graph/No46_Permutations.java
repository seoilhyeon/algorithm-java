package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class No46_Permutations {

    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> buffer = new ArrayList<>();
        boolean[] used = new boolean[21];

        public List<List<Integer>> permute(int[] nums) {
            backtrack(nums, 0);
            return ans;
        }

        void backtrack(int[] nums, int k) {
            if (nums.length == k) {
                ans.add(new ArrayList<>(buffer));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[nums[i] + 10])
                    continue;

                used[nums[i] + 10] = true;
                buffer.add(nums[i]);
                backtrack(nums, k + 1);
                buffer.remove(buffer.size() - 1);
                used[nums[i] + 10] = false;
            }
        }
    }
}
