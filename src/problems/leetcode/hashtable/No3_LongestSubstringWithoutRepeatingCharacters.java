package problems.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

public class No3_LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            char[] chars = s.toCharArray();
            int i = 0, j = 0, maxLen = 0;
            Set<Character> containing = new HashSet<>();

            while (j < s.length()) {
                if (!containing.contains(chars[j])) {
                    containing.add(chars[j++]);
                    maxLen = Math.max(maxLen, j - i);
                } else {
                    containing.remove(chars[i++]);
                }
            }

            return maxLen;
        }
    }
}
