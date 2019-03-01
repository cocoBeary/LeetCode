/**
62. Unique Paths
Medium

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?


Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3

Output: 28
 */

import java.util.*;

public class UniquePaths {
	public int uniquePaths(int m, int n) {
		int N = n + m - 2;// how much steps we need to do
		int k = Math.min(m - 1, n - 1);
		long res = 1;
		// here we calculate the total possible path number
		// Combination(N, k) = n! / (k!(n - k)!)
		// reduce the numerator and denominator and get
		// C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
		for (int i = 1; i <= k; i++)
			res = res * (N - k + i) / i;
		return (int) res;

		
//		if (m <= 0 || n <= 0)
//			return 0;
//
//		int[] r = new int[n];
//		r[0] = 1;
//
//		for (int i = 0; i < m; i++)
//			for (int j = 0; j < n; j++) {
//				r[j] = j > 0 ? r[j - 1] + r[j] : r[j];
//			}
//
//		return r[n - 1];
		
		
//		if (m <= 0 || n <= 0)
//			return 0;
//
//		int[][] r = new int[m][n];
//		for (int i = 0; i < m; i++)
//			r[i][0] = 1;
//		for (int j = 0; j < n; j++)
//			r[0][j] = 1;
//
//		for (int i = 1; i < m; i++)
//			for (int j = 1; j < n; j++) {
//				r[i][j] = r[i - 1][j] + r[i][j - 1];
//			}
//
//		return r[m - 1][n - 1];
	}

	public static void main(String[] args) {
		UniquePaths test = new UniquePaths();
		System.out.println(test.uniquePaths(5, 0));
		System.out.println(test.uniquePaths(3, 2));
		System.out.println(test.uniquePaths(7, 3));
		System.out.println(test.uniquePaths(100, 50));
	}
}
