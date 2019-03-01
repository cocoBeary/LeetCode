
/**
 * 41. First Missing Positive
 * 
 * Hard
 * 
 * Array
 * 
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * Example 1:
 * 
 * Input: [1,2,0]
 * 
 * Output: 3
 * 
 * Example 2:
 * 
 * Input: [3,4,-1,1]
 * 
 * Output: 2
 * 
 * Example 3:
 * 
 * Input: [7,8,9,11,12]
 * 
 * Output: 1
 * 
 * Note:
 * 
 * Your algorithm should run in O(n) time and uses constant extra space.
 * 
 * Time O(n) Space O(1)
 *
 */

import java.util.*;

public class FirstMissingPositive {
	// 0,1,2,3
	// 1,2,3,4

	// 3,4,-1,1
	// -1,4,3,1
	// -1,1,3,4
	// 1,-1,3,4
	// 1,-1,3,4

	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 1;
		for (int i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}

		for (int i = 0; i < nums.length; i++)
			if (nums[i] != i + 1)
				return i + 1;

		return nums.length + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, -1, 1 };
		FirstMissingPositive test = new FirstMissingPositive();
		System.out.println(test.firstMissingPositive(nums));
	}

}
