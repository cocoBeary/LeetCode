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

	// time O(n+m) space O(1)
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

	public static void main(String[] args) {
		ImplementstrStr test = new ImplementstrStr();
		System.out.println(test.strStr("hello", ""));
		//System.out.println(("hello".indexOf("ll")));
	}
}
