// 128. Longest Consecutive Sequence

// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

// Your algorithm should run in O(n) complexity.

// Input: [100, 4, 200, 1, 3, 2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
	// HashSet
	public int longestConsecutive1(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;
		for (int num : nums)
			set.add(num);
		for (int num : nums) {
			if (set.remove(num)) {
				int val = num;
				int sum = 1;
				while (set.remove(++val))
					sum++;
				val = num;
				while (set.remove(--val))
					sum++;
				max = Math.max(max, sum);
			}
			if (set.isEmpty())
				return max;
		}
		return max;
	}

	// HashMap
	public int longestConsecutive2(int[] nums) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (!map.containsKey(num)) {
				int left = map.containsKey(num - 1) ? map.get(num - 1) : 0;
				int right = map.containsKey(num + 1) ? map.get(num + 1) : 0;
				int sum = right + left + 1;
				res = Math.max(res, sum);
				map.put(num, sum);
				map.put(num - left, sum);
				map.put(num + right, sum);
			} else {
				continue;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 100, 4, 200, 1, 3, 2 };
		LongestConsecutiveSequence test = new LongestConsecutiveSequence();
		System.out.print(test.longestConsecutive1(nums));
		System.out.print(test.longestConsecutive2(nums));
	}

}