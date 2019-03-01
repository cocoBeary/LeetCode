import java.util.*;

// 123. Best Time to Buy and Sell Stock III

// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. You may complete at most two transactions.

// Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

// Example 1:

// Input: [3,3,5,0,0,3,1,4]
// Output: 6
// Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             // Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
// Example 2:

// Input: [1,2,3,4,5]
// Output: 4
// Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
             // Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
             // engaging multiple transactions at the same time. You must sell before buying again.
// Example 3:

// Input: [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.

public class BestTimeToBuyAndSellStockIII {
	public int maxProfit(int[] prices) {
		int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
		int release1 = 0, release2 = 0;
		for (int i : prices) {
//			hold1 = Math.max(hold1, -i);
//			release1 = Math.max(release1, hold1 + i);
//			hold2 = Math.max(hold2, release1 - i);
//			release2 = Math.max(release2, hold2 + i);
						
			release2 = Math.max(release2, hold2 + i);
			hold2 = Math.max(hold2, release1 - i);
			release1 = Math.max(release1, hold1 + i);
			hold1 = Math.max(hold1, -i);
			System.out.println(i + "\t->  " + hold1 + "\t" + release1 + "\t" + hold2 + "\t" + release2);
		}
		return release2;
	}

	public static void main(String[] args) {
		//int[] nums = { 1, 2, 3, 4};
		//int[] nums = { 7, 10, 6, 1, 3, 5, 70, 2, 4, 100};
		int[] nums = { 1, 3, 5, 70, 2, 4, 100, 7, 10, 6 };
		BestTimeToBuyAndSellStockIII test = new BestTimeToBuyAndSellStockIII();
		System.out.println(test.maxProfit(nums));
	}
}
