package problems.leetcode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class No17_LetterCombinationsOfAPhoneNumber {

    class Solution {
        static Map<Character, List<Character>> mapping = Map.of(
                '2', List.of('a', 'b', 'c'),
                '3', List.of('d', 'e', 'f'),
                '4', List.of('g', 'h', 'i'),
                '5', List.of('j', 'k', 'l'),
                '6', List.of('m', 'n', 'o'),
                '7', List.of('p', 'q', 'r', 's'),
                '8', List.of('t', 'u', 'v'),
                '9', List.of('w', 'x', 'y', 'z'));

        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        public List<String> letterCombinations(String digits) {
            backtrack(digits, 0);
            return ans;
        }

        void backtrack(String digits, int k) {
            if (digits.length() == k) {
                ans.add(sb.toString());
                return;
            }

            for (char ch : mapping.get(digits.charAt(k))) {
                sb.append(ch);
                backtrack(digits, k + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
