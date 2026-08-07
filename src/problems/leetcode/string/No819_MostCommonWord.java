package problems.leetcode.string;

import java.util.*;

public class No819_MostCommonWord {

    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> banSet = new HashSet<>(Arrays.asList(banned));
            Map<String, Integer> counter = new HashMap<>();
            for (String word : paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ")) {
                if (banSet.contains(word))
                    continue;
                counter.put(word, counter.getOrDefault(word, 0) + 1);
            }
            return Collections.max(counter.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
    }
}