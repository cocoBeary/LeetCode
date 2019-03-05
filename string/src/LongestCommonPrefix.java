/***
 * 14. Longest Common Prefix
 * 
 * Easy
 * 
 * Write a function to find the longest common prefix string amongst an array of
 * strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: ["flower","flow","flight"]
 * 
 * Output: "fl"
 * 
 * Example 2:
 * 
 * Input: ["dog","racecar","car"]
 * 
 * Output: ""
 * 
 * Explanation: There is no common prefix among the input strings.
 * 
 * Note:
 * 
 * All given inputs are in lowercase letters a-z.
 *
 */

public class LongestCommonPrefix {
	// Time: O(n) Space: O(1)
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
	
/*	
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		String res = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(res) != 0) {
				res = res.substring(0, res.length() - 1);
			}
		}
		return res;
	}
*/
	
	public static void main(String[] args) {
		LongestCommonPrefix test = new LongestCommonPrefix();
		String[] strs = { "flower", "flow", "flight" };
		System.out.println(test.longestCommonPrefix(strs));
	}
}
