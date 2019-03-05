import java.util.*;

// 3. Longest Substring Without Repeating Characters
// Medium
// HashTable, Two Pointer, String
// Given a string, find the length of the longest substring without repeating characters.

// Example 1:

// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 
// Example 2:

// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
// Example 3:

// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
//             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;

		int maxLen = 0;
		int len = 0;

		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			while (set.contains(s.charAt(i))) {
				set.remove(s.charAt(i - len--));
			}
			set.add(s.charAt(i));
			len++;
			maxLen = Math.max(maxLen, len);
		}

		return maxLen;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(test.lengthOfLongestSubstring("bbbbb"));
		System.out.println(test.lengthOfLongestSubstring("pwwkew"));
	}
}
