/***
 * 
 * 238. Product of Array Except Self
 * 
 * Medium
 * 
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * Input: [1,2,3,4]
 * 
 * Output: [24,12,8,6]
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * 
 * Could you solve it with constant space complexity? (The output array does not
 * count as extra space for the purpose of space complexity analysis.)
 *
 */

public class ProductofArrayExceptSelf {
	// time O(n) space O(n)
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int left = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] = res[i] * left;
			left *= nums[i];
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		ProductofArrayExceptSelf test = new ProductofArrayExceptSelf();
		for (int i = 0; i < nums.length; i++)
			System.out.println(test.productExceptSelf(nums)[i]);
	}
}
