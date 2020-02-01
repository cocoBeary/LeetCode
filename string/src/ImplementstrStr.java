import java.util.Arrays;

/***
 * 28. Implement strStr()
 *
 * Easy
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 *
 * Output: 2
 *
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 *
 * Output: -1
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great
 * question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty
 * string. This is consistent to C's strstr() and Java's indexOf().
 *
 */

public class ImplementstrStr {
    // time O(nm) space O(1)
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // time O(n+m) space O(1) worst case time O(nm)
    public int sunday(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length())
            return -1;

        if (needle.isEmpty())
            return 0;

        char[] a = haystack.toCharArray();
        char[] b = needle.toCharArray();

        int aL = a.length;
        int bL = b.length;

        int[] shift = new int[256];
        Arrays.fill(shift, bL + 1);

        for (int i = 0; i < bL; i++)
            shift[(int) b[i]] = bL - i;

        int i = 0;
        for (int pos = 0; pos <= aL - bL; pos += shift[(int) a[pos + bL]]) {
            for (i = 0; i < bL && a[pos + i] == b[i]; i++)
                ;
            if (i == bL)
                return pos;
            if (pos == aL - bL)
                break;
        }
        return -1;
    }

    // time O(n+m) space O(m)
    int KMP(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        if (n == 0) {
            return 0;
        }

        int[] lps = getLPS(needle);

        int i = 0, j = 0;

        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == n) {
                    return i - n;
                }
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }

        return -1;
    }

    int[] getLPS(String str) {
        // 初始化一个 lps 数组用来保存最终的结果
        int[] lps = new int[str.length()];

        // lps 的第一个值一定是 0，即长度为 1 的字符串的最长公共前缀后缀的长度为 0，直接从第二个位置遍历。并且，初始化当前最长的 lps 长度为 0，用 len 变量记录下
        int i = 1, len = 0;

        // 指针 i 遍历整个输入字符串
        while (i < str.length()) {
            // 若 i 指针能延续前缀和后缀，则更新 lps 值为 len+1
            if (str.charAt(i) == str.charAt(len)) {
                lps[i++] = ++len;
                // 否则，判断 len 是否大于 0，尝试第二长的前缀和后缀，是否能继续延续下去/
            } else if (len > 0) {
                len = lps[len - 1];
                // 所有的前缀和后缀都不符合，则当前的 lps 为 0，i++
            } else {
                i++;
            }
        }

        return lps;
    }

    public static void main(String[] args) {
        ImplementstrStr test = new ImplementstrStr();
        //System.out.println(test.sunday("peo pohopeople haha", "peop"));
        System.out.println(test.KMP("ABC ABCDAB ABCDABCDABDE", "ABCDABD"));
        //System.out.println(("hello".indexOf("ll")));
    }
}
