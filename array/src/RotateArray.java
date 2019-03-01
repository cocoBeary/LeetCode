import java.util.Arrays;

/***
 * 189. Rotate Array
 * 
 * Easy
 * 
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: [1,2,3,4,5,6,7] and k = 3
 * 
 * Output: [5,6,7,1,2,3,4]
 * 
 * Explanation:
 * 
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * 
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * 
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * 
 * Input: [-1,-100,3,99] and k = 2
 * 
 * Output: [3,99,-1,-100]
 * 
 * Explanation:
 * 
 * rotate 1 steps to the right: [99,-1,-100,3]
 * 
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * Note:
 * 
 * 
 * Try to come up as many solutions as you can, there are at least 3 different
 * ways to solve this problem.
 * 
 * Could you do it in-place with O(1) extra space?
 * 
 */

public class RotateArray {
	// time O(n) space O(n)
	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;

		int[] temp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			temp[(i + k) % nums.length] = nums[i];
		}
		System.arraycopy(temp, 0, nums, 0, nums.length);

//		for (int i = 0; i < nums.length; i++) {
//			nums[i] = temp[i];
//		}
	}

	// time O(n) space O(1)
	// 1234567 shift 3
	// 7654321
	// 5674321
	// 5671234
	public void rotate2(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		RotateArray test = new RotateArray();
		test.rotate(nums, 2);
		System.out.println(nums);
	}

}
