/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Medium
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] A, int target) {
        int start = firstGreaterEqual(A, target);
        if (start == A.length || A[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual(A, target + 1) - 1};
    }

    private int firstGreaterEqual(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target > A[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private int findEqual(int[] A, int target) {
        int low = 0, high = A.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(target == A[mid])
                return mid;
            else if (target > A[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
