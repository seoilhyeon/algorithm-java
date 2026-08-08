package problems.leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class No316_RemoveDuplicateLetters {

    class Solution {
        public String removeDuplicateLetters(String s) {
            int[] remaining = new int[26];
            for (char ch : s.toCharArray()) {
                remaining[ch - 'a']++;
            }

            Deque<Character> dq = new ArrayDeque<>();
            boolean[] containing = new boolean[26];
            for (char ch : s.toCharArray()) {
                int idx = ch - 'a';
                remaining[idx]--;
                if (containing[idx])
                    continue;

                while (!dq.isEmpty() && (dq.peekLast() > ch && remaining[dq.peekLast() - 'a'] > 0)) {
                    containing[dq.pollLast() - 'a'] = false;
                }

                dq.addLast(ch);
                containing[idx] = true;
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : dq) {
                sb.append(ch);
            }
            return sb.toString();
        }
    }
}
