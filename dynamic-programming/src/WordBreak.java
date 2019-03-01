
/**
139. Word Break
Medium

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

import java.util.*;

public class WordBreak {
	public boolean wordBreak2(String s, List<String> wordDict) {
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;

		// First DP
//		for (int i = 1; i <= s.length(); i++) {
//			for (String str : wordDict) {
//				if (str.length() <= i && f[i - str.length()] && s.substring(i - str.length(), i).equals(str)) {
//					f[i] = true;
//					break;
//				}
//			}
//		}
		
		// Second DP
        
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (f[j] && wordDict.contains(s.substring(j, i))) {
					f[i] = true;
					break;
				}
			}
		}
		
		for(int i = 0; i < f.length; i++)
		{
			System.out.print(f[i]+":");
			if(i-1>=0)
				System.out.print(s.charAt(i-1)+",");		
		}
		System.out.println();

		return f[s.length()];
	}
	
	public boolean wordBreak(String s, List<String> wordDict) {
		int longestWord = 0;
		Set<String> set = new HashSet<>();
		for (String word : wordDict) {
			longestWord = Math.max(longestWord, word.length());
			set.add(word);
		}

		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for (int j = i - 1; j >= Math.max(i - longestWord, 0); j--) {
				if (f[j] && set.contains(s.substring(j, i))) {
					f[i] = true;
					break; // next i
				}
			}
		}
		return f[s.length()];
	}

	public static void main(String[] args) {
		WordBreak test = new WordBreak();
		System.out.println(test.wordBreak2("applepenapple", new ArrayList<String>(Arrays.asList("apple", "pen"))));
		System.out.println(
				test.wordBreak2("catsanddog", new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
	}
}
