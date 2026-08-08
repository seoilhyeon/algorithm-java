package problems.leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class No20_ValidParentheses {

    class Solution {
        public boolean isValid(String s) {
            Map<Character, Character> pairMap = new HashMap<>() {
                {
                    put('(', ')');
                    put('{', '}');
                    put('[', ']');
                }
            };
            Deque<Character> dq = new ArrayDeque<>();
            for (char ch : s.toCharArray()) {
                if (pairMap.containsKey(ch))
                    dq.addLast(ch);
                else if (dq.isEmpty() || pairMap.get(dq.peekLast()) != ch)
                    return false;
                else
                    dq.pollLast();
            }

            return dq.isEmpty();
        }
    }
}
