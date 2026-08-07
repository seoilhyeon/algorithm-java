package problems.leetcode.string;

/**
 * 문자열 s가 주어졌을 때, 부분 문자열 중 가장 긴 팰린드롬 문자열을 찾아라
 */
public class No5_LongestPalindromicSubstring {

    /**
     * 단순히 생각하면 모든 케이스에 대해 팰린드롬 판정하기.
     * 이건 부분 문자열 검색만 O(N^2). 팰린드롬 판정은 O(N).
     * 따라서, O(N^3)이고, N <= 10^3라서 무조건 TLE임
     * 
     * 그럼 부분 문자열 검색을 줄여야함..
     * 
     * how..? 중간부터 좌우로 확장시키면 불필요한 케이스는 걸러짐..
     * "확장"이 메인 아이디어다.. 근데 가운데에 문자가 0개, 1개인 경우를 구분해야함.
     * 이러면 시간 복잡도 O(NK)
     */
    class Solution {
        int idx, maxLen;

        public String longestPalindrome(String s) {
            for (int i = 0; i < s.length(); i++) {
                expand(s, i, i);
                expand(s, i, i + 1);
            }

            return s.substring(idx, idx + maxLen);
        }

        void expand(String s, int i, int j) {
            while (i >= 0 && j < s.length()) {
                if (s.charAt(i) != s.charAt(j))
                    break;

                i--;
                j++;
            }

            if (maxLen < j - i - 1) {
                idx = i + 1;
                maxLen = j - i - 1;
            }
        }
    }
}
