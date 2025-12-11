package problems.leetcode.hashtable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class No3_LongestSubstringWithoutRepeatingCharacters {
    class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> containSet = new HashSet<>();
            int maxLen = 0, start = 0, end = 0;
            for (char c : s.toCharArray()) {
                while (start != end && containSet.contains(c)) {
                    containSet.remove(s.charAt(start));
                    start++;
                }
                containSet.add(c);
                end++;
                maxLen = Math.max(maxLen, end - start);
            }
            return maxLen;
        }
    }
}
