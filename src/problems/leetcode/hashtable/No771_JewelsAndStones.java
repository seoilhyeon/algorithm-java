package problems.leetcode.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No771_JewelsAndStones {
    class Solution1 {
        public int numJewelsInStones(String jewels, String stones) {
            int count = 0;
            Set<Character> jewelSet = new HashSet<>();
            for (char c : jewels.toCharArray()) {
                jewelSet.add(c);
            }
            for (char c : stones.toCharArray()) {
                if (jewelSet.contains(c)) {
                    count++;
                }
            }
            return count;
        }
    }

    class Solution2 {
        public int numJewelsInStones(String jewels, String stones) {
            Map<Character, Integer> freqs = new HashMap<>();
            for (char c : stones.toCharArray()) {
                freqs.put(c, freqs.getOrDefault(c, 0) + 1);
            }

            int count = 0;
            for (char c : jewels.toCharArray()) {
                count += freqs.getOrDefault(c, 0);
            }
            return count;
        }
    }
}
