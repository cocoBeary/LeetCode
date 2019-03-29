/***
 * 
 * 316. Remove Duplicate Letters Hard
 * 
 * Share Given a string which contains only lowercase letters, remove duplicate
 * letters so that every letter appear once and only once. You must make sure
 * your result is the smallest in lexicographical order among all possible
 * results.
 * 
 * Example 1:
 * 
 * Input: "bcabc" Output: "abc" Example 2:
 * 
 * Input: "cbacdcbc" Output: "acdb"
 *
 */
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		int[] cnt = new int[26];
		for (int i = 0; i < s.length(); i++)
			cnt[s.charAt(i) - 'a']++;
		boolean[] used = new boolean[26];
		int pos = -1;
		int[] cache = null;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while (i < s.length()) {
			if (used[s.charAt(i) - 'a']) {
				i++;
				continue;
			}
			if (pos == -1 || s.charAt(i) < s.charAt(pos)) {
				pos = i;
				cache = cnt.clone();
			}
			if (--cnt[s.charAt(i) - 'a'] == 0) {
				i = pos;
				cnt = cache;
				used[s.charAt(i) - 'a'] = true;
				sb.append(s.charAt(i));
				pos = -1;
			}
			i++;
		}
		return sb.toString();
	}

	public String removeDuplicateLettersRecursive(String s) {
		int[] cnt = new int[26];
		int pos = 0; // the position for the smallest s[i]
		for (int i = 0; i < s.length(); i++)
			cnt[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos))
				pos = i;
			if (--cnt[s.charAt(i) - 'a'] == 0)
				break;
		}
		return s.length() == 0 ? ""
				: s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}

	public static void main(String[] args) {
		System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
	}
}
