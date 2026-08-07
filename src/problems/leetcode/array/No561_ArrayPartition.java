package problems.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No561_ArrayPartition {

    class Solution1 {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length; i += 2) {
                ans += nums[i];
            }
            return ans;
        }
    }

    class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);

            List<Integer> pair = new ArrayList<>();
            int sum = 0;

            for (int n : nums) {
                pair.add(n);

                if (pair.size() == 2) {
                    sum += Math.min(pair.get(0), pair.get(1));
                    pair.clear();
                }
            }

            return sum;
        }
    }
}
