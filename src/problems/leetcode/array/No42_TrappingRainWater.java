package problems.leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

public class No42_TrappingRainWater {

    class Solution1 {
        public int trap(int[] height) {
            int i = 0, j = height.length - 1;
            int maxLeft = 0, maxRight = 0;
            int waters = 0;

            while (i < j) {
                maxLeft = Math.max(maxLeft, height[i]);
                maxRight = Math.max(maxRight, height[j]);

                int target = Math.min(maxLeft, maxRight);
                if (height[i] < height[j]) {
                    waters += target - height[i++];
                } else {
                    waters += target - height[j--];
                }
            }

            return waters;
        }
    }

    class Solution {
        public int trap(int[] height) {
            Deque<Integer> dq = new ArrayDeque<>();
            int waters = 0;
            for (int i = 0; i < height.length; i++) {
                while (!dq.isEmpty() && height[dq.peekLast()] < height[i]) {
                    int top = dq.pollLast();
                    if (dq.isEmpty())
                        continue;

                    int h = Math.min(height[dq.peekFirst()], height[i]) - height[top];
                    int w = top - dq.peekLast();
                    waters += w * h;
                }
                dq.addLast(i);
            }
            return waters;
        }
    }
}
