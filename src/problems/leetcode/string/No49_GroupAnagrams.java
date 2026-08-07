package problems.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No49_GroupAnagrams {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> anagramMap = new HashMap<>();
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);

                anagramMap.putIfAbsent(key, new ArrayList<>());
                anagramMap.get(key).add(s);
            }

            return anagramMap.values().stream().toList();
        }
    }
}