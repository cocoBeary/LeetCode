/***
 * 
 * 334. Increasing Triplet Subsequence
 * 
 * Medium
 * 
 * Given an unsorted array return whether an increasing subsequence of length 3
 * exists or not in the array.
 * 
 * Formally the function should:
 * 
 * Return true if there exists i, j, k
 * 
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return
 * false.
 * 
 * Note: Your algorithm should run in O(n) time complexity and O(1) space
 * complexity.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5]
 * 
 * Output: true
 * 
 * Example 2:
 * 
 * Input: [5,4,3,2,1]
 * 
 * Output: false
 */

public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;

		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int i : nums) {
			if (i <= small)
				small = i;
			else if (i <= big)
				big = i;
			else
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, 3 };
		IncreasingTripletSubsequence test = new IncreasingTripletSubsequence();
		System.out.print(test.increasingTriplet(nums));
	}
}
