package problems.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15_3Sum {
    /**
     * 1. 브루트 포스 -> O(N^3) -> 시간 초과 (N <= 3000)
     * 2. 투 포인터 -> O(N^2)
     * 
     * 이 문제는 세 수의 합이 0이 되는 조합을 리턴하는 문제임.
     * 인덱스를 리턴하는 것이 아니라 정렬해도 된다.
     */
    class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> triplets = new ArrayList<>();

            for (int i = 0; i < nums.length - 2; i++) {
                if (i > 0 && nums[i - 1] == nums[i]) {
                    continue;
                }

                int j = i + 1, k = nums.length - 1;

                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        triplets.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    }
                }
            }

            return triplets;
        }
    }
}
