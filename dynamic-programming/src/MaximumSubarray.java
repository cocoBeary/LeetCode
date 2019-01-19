// 53. Maximum Subarray

// Given an integer array nums, 
// find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] res = new int[nums.length];
		int max = nums[0];
		res[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			res[i] = nums[i] + (res[i - 1] > 0 ? res[i - 1] : 0);
			max = Math.max(max, res[i]);
		}
		return max;
	}
	
	public int maxSubArray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int max = nums[0];
		int currentSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			currentSum = nums[i] + (currentSum > 0 ? currentSum : 0);
			max = Math.max(max, currentSum);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		MaximumSubarray test = new MaximumSubarray();
		System.out.println(test.maxSubArray2(nums));
	}
}
