package problems.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No561_ArrayPartition {
    /**
     * pair의 최솟값들의 합이 최대가 되려면... 두 수 사이의 차이가 최소여야 한다.
     * 정렬 -> 쌍으로 묶기 -> 차이가 최소임이 보장됨
     * 
     * 1. 정렬 후 짝수 번째 index 합
     * 2. 정렬 후 짝만들어 최소값들의 합 구하기
     */
    class Solution1 {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }
            return sum;
        }
    }

    class Solution2 {
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
