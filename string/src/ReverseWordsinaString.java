/**
 * 151. Reverse Words in a String
 * 
 * Medium
 * 
 * Given an input string, reverse the string word by word.
 * 
 * Example 1:
 * 
 * Input: "the sky is blue"
 * 
 * Output: "blue is sky the"
 * 
 * Example 2:
 * 
 * Input: " hello world! "
 * 
 * Output: "world! hello"
 * 
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * Example 3:
 * 
 * Input: "a good example"
 * 
 * Output: "example good a"
 * 
 * Explanation: You need to reduce multiple spaces between two words to a single
 * space in the reversed string.
 * 
 * Note:
 * 
 * A word is defined as a sequence of non-space characters.
 * 
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * 
 * You need to reduce multiple spaces between two words to a single space in the
 * reversed string.
 * 
 * Follow up:
 * 
 * For C programmers, try to solve it in-place in O(1) extra space.
 *
 */

public class ReverseWordsinaString {
	// stringBuilder time O(n) space O(n)
	public String reverseWords(String s) {
		if (s == null || s.length() == 0)
			return s;
		StringBuilder sb = new StringBuilder();
		String[] words = s.trim().split("\\s+");
		for (int i = words.length - 1; i >= 0; i--) {
			sb.append(words[i] + " ");
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		String s = "a good example";
		System.out.println(new ReverseWordsinaString().reverseWords(s));
	}

}
