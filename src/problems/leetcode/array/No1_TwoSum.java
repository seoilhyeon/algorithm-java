package problems.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No1_TwoSum {

    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }
            return null;
        }
    }

    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> idxMap = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int need = target - nums[i];
                if (idxMap.containsKey(need))
                    return new int[] { idxMap.get(need), i };
                idxMap.put(nums[i], i);
            }

            return null;
        }
    }
}
