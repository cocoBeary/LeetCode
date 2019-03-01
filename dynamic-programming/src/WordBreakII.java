/**
 * 
140. Word Break II
Hard

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
 *
 */

import java.util.*;

public class WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		return null;
	}

	public static void main(String[] args) {
		WordBreakII test = new WordBreakII();
		System.out.println(test.wordBreak("applepenapple", new ArrayList<String>(Arrays.asList("apple", "pen"))));
		System.out.println(test.wordBreak("catsanddog",
				new ArrayList<String>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
	}
}
