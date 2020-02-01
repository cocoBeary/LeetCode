/**
 * 31. Next Permutation
 * Medium
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 *
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2)
            return;

        int firstSmall = nums.length - 2;
        while (firstSmall >= 0 && nums[firstSmall] >= nums[firstSmall + 1])
            firstSmall--;

        if (firstSmall == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int firstBig = nums.length - 1;
        while (nums[firstSmall] >= nums[firstBig])
            firstBig--;

        swap(nums, firstSmall, firstBig);
        reverse(nums, firstSmall + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
