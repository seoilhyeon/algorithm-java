package problems.leetcode.hashtable;

import java.util.HashMap;

public class No771_JewelsAndStones {

    class Solution1 {
        public int numJewelsInStones(String jewels, String stones) {
            Set<Character> js = new HashSet<>();
            for (char j : jewels.toCharArray()) {
                js.add(j);
            }

            int count = 0;
            for (char s : stones.toCharArray()) {
                if (js.contains(s))
                    count++;
            }

            return count;
        }
    }

    class Solution2 {
        public int numJewelsInStones(String jewels, String stones) {
            Map<Character, Integer> freq = new HashMap<>();
            for (char s : stones.toCharArray()) {
                freq.put(s, freq.getOrDefault(s, 0) + 1);
            }

            int count = 0;
            for (char j : jewels.toCharArray()) {
                count += freq.getOrDefault(j, 0);
            }
            return count;
        }
    }
}
