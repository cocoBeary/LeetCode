
/**
 * 
 * 42. Trapping Rain Water Hard
 * 
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * 
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In
 * this case, 6 units of rain water (blue section) are being trapped. Thanks
 * Marcos for contributing this image!
 * 
 * Example:
 * 
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1] Output: 6
 *
 */

import java.util.*;
import java.util.stream.Collectors;

public class TrappingRainWater {
	// Time O(nm) Space O(1)
	public int trap1(int[] height) {
		if (height == null || height.length <= 1)
			return 0;
		int n = height.length;		
		// int m = Arrays.stream(height).boxed().max((x, y) -> x - y).get();
		int m = 0;
		for (int i : height)
			m = Math.max(m, i);

		int sum = 0;
		for (int i = 1; i <= m; i++) {
			int start = 0, end = n - 1;
			while (height[start] < i && start <= end) start++;
			while (height[end] < i && start <= end) end--;
			if (end - start <= 1) continue;
			
			for (int j = start + 1; j <= end - 1; j++)
				if (height[j] < i) sum++;
		}
		return sum;
	}
	
	// Time O(n2) Space O(1)
	public int trap2(int[] height) {
		if (height == null || height.length <= 1)
			return 0;
		
		int sum = 0;
		for (int i = 1; i < height.length - 1; i++) {
			int max_left = height[i], max_right = height[i];
			for (int j = i - 1; j >= 0; j--)
				if (height[j] > max_left)
					max_left = height[j];
			for (int j = i + 1; j < height.length; j++)
				if (height[j] > max_right)
					max_right = height[j];
			
			sum += Math.min(max_left, max_right) - height[i];
		}
		return sum;
	}
	
	// Time O(n) Space O(n)
	public int trap3(int[] height) {
		if (height == null || height.length <= 1)
			return 0;

		int sum = 0;
		int n = height.length;
		int[] max_left = new int[n];
		int[] max_right = new int[n];
		max_left[0] = height[0];
		max_right[n - 1] = height[n - 1];

		for (int i = 1; i < n - 1; i++)
			max_left[i] = Math.max(max_left[i - 1], height[i]);
		for (int i = n - 2; i >= 0; i--)
			max_right[i] = Math.max(max_right[i + 1], height[i]);
		for (int i = 1; i < n - 1; i++)
			sum += Math.min(max_left[i], max_right[i]) - height[i];

		return sum;
	}
	
	// Time O(n) Space O(1)
	public int trap(int[] height) {
		if (height == null || height.length <= 1)
			return 0;

		int sum = 0;
		int n = height.length;
		int max_left = height[0];
		int max_right = height[n - 1];
		int left = 0;
		int right = n - 1;
		for (int i = 0; i < n; i++) {
			if (height[left] < height[right]) {
				max_left = Math.max(max_left, height[left]);
				sum = sum + (max_left - height[left]);
				left++;
			} else {
				max_right = Math.max(max_right, height[right]);
				sum = sum + (max_right - height[right]);
				right--;
			}
		}
		return sum;
	}
	
	public int trap5(int[] height) {
	    int sum = 0;
	    Stack<Integer> stack = new Stack<>();
	    int current = 0;
	    while (current < height.length) {
	        while (!stack.empty() && height[current] > height[stack.peek()]) {
	            int h = height[stack.peek()];
	            stack.pop();
	            if (stack.empty()) {
	                break; 
	            }
	            int distance = current - stack.peek() - 1;
	            int min = Math.min(height[stack.peek()], height[current]);
//	            System.out.println("Current H: "+height[current] + " Removed H: "+ h+ " After remove: "+ height[stack.peek()]);
//	            System.out.println("distance: "+distance + " min-h: "+ (min-h));
//	            System.out.println();
	            sum = sum + distance * (min - h);
	        }
	        stack.push(current);
	        current++;
	    }
	    return sum;
	}	

	public static void main(String[] args) {
		int[] nums = { 2, 1, 0, 1, 3 };
		TrappingRainWater test = new TrappingRainWater();
		System.out.println(test.trap(nums));
	}
}
