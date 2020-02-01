/**
 * 44. Wildcard Matching
 * Hard
 *
 * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 *
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 * Example 1:
 *
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input:
 * s = "aa"
 * p = "*"
 * Output: true
 * Explanation: '*' matches any sequence.
 * Example 3:
 *
 * Input:
 * s = "cb"
 * p = "?a"
 * Output: false
 * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 * Example 4:
 *
 * Input:
 * s = "adceb"
 * p = "*a*b"
 * Output: true
 * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 * Example 5:
 *
 * Input:
 * s = "acdcb"
 * p = "a*c?b"
 * Output: false
 */

public class WildcardMatching {
    // time O(n) space O(0)
    public boolean isMatch(String s, String p) {
        int sp = 0, pp = 0, sstar = 0, pstar = -1;
        while (sp < s.length()) {
            if (pp < p.length() && (p.charAt(pp) == s.charAt(sp) || p.charAt(pp) == '?')) {
                sp++;
                pp++;
            } else if (pp < p.length() && p.charAt(pp) == '*') {
                sstar = sp;
                pstar = pp;
                pp++;
            } else if (pstar != -1) {
                sstar++;
                pp = pstar + 1;
                sp = sstar;
            } else
                return false;
        }

        while (pp < p.length() && p.charAt(pp) == '*')
            pp++;

        return pp == p.length();
    }

    public static void main(String[] args) {
        WildcardMatching test = new WildcardMatching();
        String s = "abcbcd";
        String p = "a*bcd";
        System.out.println(test.isMatch(s, p));

        s = "good morning";
        p = "g*mor*g";
        System.out.println(test.isMatch(s, p));
    }
}
