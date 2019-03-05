/***
 * 
 * 387. First Unique Character in a String
 * 
 * Easy
 * 
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * Examples:
 * 
 * s = "leetcode"
 * 
 * return 0.
 * 
 * s = "loveleetcode",
 * 
 * return 2.
 * 
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterinaString {
	public int firstUniqChar(String s) {
		if (s == null || s.isEmpty())
			return -1;

		int[] freq = new int[256];		
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i)]++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (freq[s.charAt(i)] == 1)
				return i;
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstUniqueCharacterinaString test = new FirstUniqueCharacterinaString();
		System.out.println(test.firstUniqChar("loveleetcode"));
	}
}
