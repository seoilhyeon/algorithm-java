package problems.leetcode.array;

public class No238_ProductOfArrayExceptSelf {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] ans = new int[nums.length];
            ans[0] = 1;

            for (int i = 0, mul = 1; i < nums.length - 1; i++) {
                mul *= nums[i];
                ans[i + 1] = mul;
            }

            for (int i = nums.length - 1, mul = 1; i > 0; i--) {
                mul *= nums[i];
                ans[i - 1] *= mul;
            }

            return ans;
        }
    }
}
