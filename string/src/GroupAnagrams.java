
/***
 * 49. Group Anagrams

Medium

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],

Output:

[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
All inputs will be in lowercase.
The order of your output does not matter.
 * 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0)
			return new ArrayList<List<String>>();
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] ch = str.toCharArray();
			Arrays.sort(ch);
			String s = new String(ch);
			if (map.containsKey(s)) {
				map.get(s).add(str);

			} else {
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(s, list);
			}
		}
		return new ArrayList<List<String>>(map.values());

	}

	public static void main(String[] args) {
		String[] nums = { "eat", "tea", "tan", "ate", "nat", "bat" };
		GroupAnagrams test = new GroupAnagrams();
		System.out.println(test.groupAnagrams(nums));
	}
}
