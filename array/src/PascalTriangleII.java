// 119. Pascal's Triangle II

// Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

// Note that the row index starts from 0.
// In Pascal's triangle, each number is the sum of the two numbers directly above it.

// Example:

// Input: 3
// Output: [1,3,3,1]
// Follow up:

// Could you optimize your algorithm to use only O(k) extra space?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII {
	// List
	public List<Integer> getRow1(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i <=rowIndex; i++) {
			res.add(0, 1);
			for (int j = 1; j < i; j++) {
					res.set(j, res.get(j) + res.get(j + 1));
			}
		}
		return res;
	}

	//array
	public List<Integer> getRow2(int rowIndex) {
		Integer[] res= new Integer[rowIndex+1];
		Arrays.fill(res, 0);
		res[0]=1;
		for(int i=1;i<=rowIndex;i++) {
			for(int j=i;j>0;j--) {
				res[j]=res[j]+res[j-1];
			}
		}
		return Arrays.asList(res);
	}
	
	public static void main(String[] args) {
		int n = 5;
		System.out.println(new PascalTriangleII().getRow1(n).toString());
		System.out.println(new PascalTriangleII().getRow2(n).toString());

	}
}
