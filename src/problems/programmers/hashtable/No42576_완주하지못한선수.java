package problems.programmers.hashtable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class No42576_완주하지못한선수 {

    class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> freq = new HashMap<>();
            for (String p : participant)
                freq.put(p, freq.getOrDefault(p, 0) + 1);

            for (String c : completion)
                freq.put(c, freq.get(c) - 1);

            return Collections.max(freq.entrySet(), Map.Entry.comparingByValue()).getKey();
        }
    }
}
