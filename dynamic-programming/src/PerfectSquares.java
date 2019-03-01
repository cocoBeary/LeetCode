
/**
 * 279. Perfect Squares Medium
 * 
 * 
 * Share Given a positive integer n, find the least number of perfect square
 * numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * Input: n = 12 Output: 3 Explanation: 12 = 4 + 4 + 4. Example 2:
 * 
 * Input: n = 13 Output: 2 Explanation: 13 = 4 + 9.
 */

import java.util.*;

public class PerfectSquares {
	public int numSquares(int n) {
		if(isSquare(n))
			return 1;
		
        // The result is 4 if and only if n can be written in the 
        // form of 4^k*(8*m + 7). Please refer to 
        // Legendre's three-square theorem.
        while ((n & 3) == 0) // n%4 == 0  
        {
            n >>= 2;  
        }
        if ((n & 7) == 7) // n%8 == 7
        {
            return 4;
        }
        
        // Check whether 2 is the result.
        int sqrt = (int)(Math.sqrt(n)); 
        for(int i = 1; i <= sqrt; i++)
        {
            if (isSquare(n - i*i)) 
            {
                return 2;  
            }
        }  
        
        return 3;
	}
	
	private boolean isSquare(int n)
	{
		int sqrt = (int)Math.sqrt(n);
		return sqrt*sqrt == n;
	}
/*	
	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; ++i) {
			int j = 1;
			int minValue = Integer.MAX_VALUE;
			while (i - j * j >= 0) {
				minValue = Math.min(minValue, dp[i - j * j] + 1);
				j++;
			}
			dp[i] = minValue;
		}

		return dp[n];
	}
*/
	public static void main(String[] args) {
		PerfectSquares test = new PerfectSquares();
		System.out.println(test.numSquares(1));
		System.out.println(test.numSquares(6));
	}
}
