import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/***
 * 
 * 217. Contains Duplicate
 * 
 * Easy
 * 
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,1]
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: [1,2,3,4]
 * 
 * Output: false
 * 
 * Example 3:
 * 
 * Input: [1,1,1,3,3,4,3,2,4,2
 *
 * 
 */
public class ContainsDuplicate {
	// hashset Time O(n) Space O(n)
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums) {
			if (!set.add(i))
				return true;
		}
		return false;
	}

	// sort Time O(nlogn) Space O(1)
	public boolean containsDuplicate2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1])
				return true;

		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 1 };
		ContainsDuplicate test = new ContainsDuplicate();
		System.out.print(test.containsDuplicate(nums));
	}
}
