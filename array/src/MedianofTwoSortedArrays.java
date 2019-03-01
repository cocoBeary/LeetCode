/**
 * 4. Median of Two Sorted Arrays
 * 
 * Hard
 * 
 * Array, Binary Search, Divide and Conquer
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 Example 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 *
 */
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l = nums1.length + nums2.length;

		if (l % 2 == 1)
			return findKth(nums1, 0, nums2, 0, l / 2 + 1);
		else
			return (findKth(nums1, 0, nums2, 0, l / 2) + findKth(nums1, 0, nums2, 0, l / 2 + 1)) / 2;
	}
	
	public double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
		if (i >= nums1.length)
			return nums2[j + k - 1];
		if (j >= nums2.length)
			return nums1[i + k - 1];
		if (k == 1)
			return nums1[i] <= nums2[j] ? nums1[i] : nums2[j];
		
		if(i+k/2-1 >= nums1.length)
			return findKth(nums1, i, nums2, j+k/2, k - k/2);		
		if(j+k/2-1 >= nums2.length)
			return findKth(nums1, i+k/2, nums2, j, k - k/2);		
		
		if(nums1[i+k/2-1] < nums2[j+k/2-1])
			return findKth(nums1, i+k/2, nums2, j, k - k/2);
		else
			return findKth(nums1, i, nums2, j+k/2, k - k/2);
	}

	public double findKths(int[] nums1, int i, int[] nums2, int j, int k) {
		if (i >= nums1.length)
			return nums2[j + k - 1];
		if (j >= nums2.length)
			return nums1[i + k - 1];
		if (k == 1)
			return nums1[i] <= nums2[j] ? nums1[i] : nums2[j];

		int idx1 = i + k / 2 - 1;
		int idx2 = j + k / 2 - 1;
		int num1 = idx1 < nums1.length ? nums1[idx1] : Integer.MAX_VALUE;
		int num2 = idx2 < nums2.length ? nums2[idx2] : Integer.MAX_VALUE;

		if (num1 <= num2)
			i += k / 2;
		else
			j += k / 2;

		return findKth(nums1, i, nums2, j, k - k / 2);
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 7, 9, 11, 13, 15, 17 };
		int[] nums2 = { 2, 4, 6, 8, 10 };
		double result = new MedianofTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
	}
}
