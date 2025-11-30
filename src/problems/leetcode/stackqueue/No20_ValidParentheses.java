package problems.leetcode.stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class No20_ValidParentheses {
    class Solution1 {
        public boolean isValid(String s) {
            Map<Character, Character> pairMap = new HashMap<>() {
                {
                    put('(', ')');
                    put('{', '}');
                    put('[', ']');
                }
            };
            Deque<Character> stack = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                if (pairMap.containsKey(c)) {
                    stack.push(c);
                } else if (stack.isEmpty() || pairMap.get(stack.pop()) != c) {
                    return false;
                }
            }

            return stack.isEmpty();
        }
    }
}
