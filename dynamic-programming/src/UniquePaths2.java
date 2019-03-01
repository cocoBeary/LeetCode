
/**
 * 63. Unique Paths II Medium
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * 
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * Input: [ [0,0,0], [0,1,0], [0,0,0] ] Output: 2 Explanation: There is one
 * obstacle in the middle of the 3x3 grid above. There are two ways to reach the
 * bottom-right corner: 1. Right -> Right -> Down -> Down 2. Down -> Down ->
 * Right -> Right
 */

import java.util.*;

public class UniquePaths2 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid != null && obstacleGrid.length > 0 ? obstacleGrid[0].length : 0;

		if (n == 0)
			return 0;

		int m = obstacleGrid.length;

		int[] r = new int[n];
		r[0] = 1;

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++) {
				r[j] = obstacleGrid[i][j] == 1 ? 0 : j > 0 ? r[j - 1] + r[j] : r[j];
			}

		return r[n - 1];
	}

	public static void main(String[] args) {
		UniquePaths2 test = new UniquePaths2();
		System.out.println(test.uniquePathsWithObstacles(new int[][] {}));
		System.out.println(test.uniquePathsWithObstacles(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } }));
	}
}
