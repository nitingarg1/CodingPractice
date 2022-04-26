public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring test = new LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("cbbd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2)
            return s;
        int longestPalindromeLength = 0;
        int start = 0;
        int end = 0;
        //create a array to store the present found palindrome
        int[][] palindromeArray = new int[s.length()][s.length()];

        //special case for length of 1 and 2
        for (int i = 0; i < s.length(); i++)
            palindromeArray[i][i] = 1;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                palindromeArray[i][i + 1] = 1;
                longestPalindromeLength = 1;
                start = i;
                end = i + 1;
            }

        }

        //for case >3
        for (int i = 0, gap = 2; gap < s.length(); i++, gap++) {
            for (int j = 0; j + gap < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + gap) && palindromeArray[j + 1][j + gap - 1] == 1) {
                    palindromeArray[j][j + gap] = 1;
                    if (longestPalindromeLength < gap) {
                        longestPalindromeLength = gap;
                        start = j;
                        end = j + gap;
                    }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}