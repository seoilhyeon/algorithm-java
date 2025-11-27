package problems.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class No1_TwoSum {
    /**
     * 1. 브루트 포스 -> O
     * 2. 해시 -> O
     * 3. 투포인터 -> 정렬 필요 -> 복잡 (위치가 변경되서 인덱스 리턴 어려움)
     */
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }
            }

            throw new IllegalStateException(); // 문제에서 답이 무조건 있다고 단정함.
        }
    }

    class Solution2 {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> hash = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (hash.containsKey(target - nums[i])) {
                    return new int[] { hash.get(target - nums[i]), i };
                }
                hash.put(nums[i], i);
            }

            throw new IllegalStateException();
        }
    }
}
