/**
 * 10. Regular Expression Matching
 * Hard
 * <p>
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * <p>
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * Example 1:
 * <p>
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 * <p>
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 * <p>
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 * <p>
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 * <p>
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */

public class RegularExpressionMatching {
    boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // 定义一个二维布尔矩阵 dp
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 当两个字符串的长度都为 0，也就是空字符串的时候，它们互相匹配
        dp[0][0] = true;

        for (int j = 2; j <= n; j++) {
            dp[0][j] = p.charAt(j - 1) == '*' && dp[0][j - 2];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // p 的当前字符不是 '*'，判断当前的两个字符是否相等，如果相等，就看 dp[i-1][j-1] 的值，因为它保存了前一个匹配的结果
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = dp[i - 1][j - 1] &&
                            isMatch(s.charAt(i - 1), p.charAt(j - 1));
                } else {
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] &&
                            isMatch(s.charAt(i - 1), p.charAt(j - 2));
                }
            }
        }

        return dp[m][n];
    }

    boolean isMatch(char a, char b) {
        return a == b || b == '.';

    }

    public static void main(String[] args) {
        String s = "aaa";
        String p = "a*";
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println(test.isMatch(s, p));
    }
}
