// 59. Spiral Matrix II

// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// Example:

// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] res=new int[n][n];
		if(n<1) return res;
		int top = 0;
		int bottom = n-1;
		int right = n-1;
		int left = 0;
		int current=1;
		while (true) {
			for (int i = top; i <= right; i++) {
				res[top][i]=current++;
			}
			top++;
			if (top > bottom || left > right)
				break;
			for (int i = top; i <= bottom; i++) {
				res[i][right]=current++;
			}
			right--;
			if (top > bottom || left > right)
				break;
			for (int i = right; i >= left; i--) {
				res[bottom][i]=current++;
			}
			bottom--;
			if (top > bottom || left > right)
				break;
			for (int i = bottom; i >= top; i--) {
				res[i][left]=current++;
			}
			left++;
			if (top > bottom || left > right)
				break;

		}
		return res;

	}

	public static void main(String[] args) {
		int[][] res=new SpiralMatrixII().generateMatrix(3);
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[0].length;j++)
			System.out.print(res[i][j]);
			System.out.println("");
		}
	}
}
