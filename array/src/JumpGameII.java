/***
 * 45. Jump Game II Hard
 * 
 * Share Given an array of non-negative integers, you are initially positioned
 * at the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps to
 * reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the
 * last index. Note:
 * 
 * You can assume that you can always reach the last index.
 *
 */
public class JumpGameII {	
	public int jump(int[] nums) {
		int end = 0;
		int maxPosition = 0;
		int steps = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			maxPosition = Math.max(maxPosition, nums[i] + i);
			if (i == end) {
				end = maxPosition;
				steps++;
			}
		}
		return steps;
	}
	
	public int jump1(int[] nums) {
		int position = nums.length - 1;
		int steps = 0;
		while (position != 0) {
			for (int i = 0; i < position; i++) {
				if (i + nums[i] >= position) {
					position = i;
					steps++;
					break;
				}
			}
		}
		return steps;
	}

	public int jump2(int[] nums) {
		if (nums == null || nums.length < 2)
			return 0;

		int N = nums.length;
		int[] dp = new int[N];

		for (int i = 1; i < N; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (j + nums[j] >= i)
					min = Math.min(min, dp[j] + 1);
			}
			dp[i] = min;
		}

		return dp[N - 1];
	}

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 1, 4 };
		int[] nums2 = { 5, 1, 1, 5, 1, 1, 1, 1, 1 };
		JumpGameII test = new JumpGameII();
		System.out.println(test.jump(nums));
		System.out.println(test.jump(nums2));
	}

}
