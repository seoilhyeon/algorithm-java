package problems.leetcode.string;

public class No125_ValidPalindrome {

    class Solution1 {
        public boolean isPalindrome(String s) {
            s = s.replaceAll("[^a-zA-Z0-9]+", "").toLowerCase();
            return (new StringBuilder(s)).reverse().toString().equals(s);
        }
    }

    class Solution2 {
        public boolean isPalindrome(String s) {
            int i = 0, j = s.length() - 1;
            while (i < j) {
                char left = s.charAt(i), right = s.charAt(j);
                if (!Character.isLetterOrDigit(left)) {
                    i++;
                    continue;
                }
                if (!Character.isLetterOrDigit(right)) {
                    j--; 
                    continue;
                }

                if (Character.toLowerCase(left) != Character.toLowerCase(right))
                    return false;

                i++;
                j--;
            }

            return true;
        }
    }
}