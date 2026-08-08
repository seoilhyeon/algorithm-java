package problems.leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class No739_DailyTemperatures {

    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Deque<Integer> dq = new ArrayDeque<>();
            int[] ans = new int[temperatures.length];

            for (int i = 0; i < temperatures.length; i++) {
                while (!dq.isEmpty() && temperatures[dq.peekLast()] < temperatures[i]) {
                    ans[dq.peekLast()] = i - dq.pollLast();
                }

                dq.add(i);
            }

            return ans;
        }
    }
}
