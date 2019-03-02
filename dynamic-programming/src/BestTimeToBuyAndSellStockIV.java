import java.util.*;

/***
 * 
 * 188. Best Time to Buy and Sell Stock IV Hard
 * 
 * 
 * Share Say you have an array for which the ith element is the price of a given
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most k
 * transactions.
 * 
 * Note: You may not engage in multiple transactions at the same time (ie, you
 * must sell the stock before you buy again).
 * 
 * Example 1:
 * 
 * Input: [2,4,1], k = 2 Output: 2 Explanation: Buy on day 1 (price = 2) and
 * sell on day 2 (price = 4), profit = 4-2 = 2. Example 2:
 * 
 * Input: [3,2,6,5,0,3], k = 2 Output: 7 Explanation: Buy on day 2 (price = 2)
 * and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price =
 * 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *
 */

public class BestTimeToBuyAndSellStockIV {
	public int maxProfit(int k, int[] prices) {
		// buy1, sell1, buy2, sell2 is the max profit at different buying and selling
		// time

		if (k <= 0 || prices == null || prices.length < 2)
			return 0;

		if (k >= prices.length)
			k = prices.length;

		int[] buy = new int[k];
		int[] sell = new int[k];
		for (int i = 0; i < k; i++)
			buy[i] = Integer.MIN_VALUE;

		for (int i = 0; i < prices.length; i++) {
			for (int j = k - 1; j >= 0; j--) {
				sell[j] = Math.max(sell[j], buy[j] + prices[i]);
				if (j > 0)
					buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
				else
					buy[j] = Math.max(buy[j], -prices[i]);
			}
		}

		return sell[k - 1];
	}

	public static void main(String[] args) {
		// int[] nums = { 1, 2, 3, 4};
		// int[] nums = { 7, 10, 6, 1, 3, 5, 70, 2, 4, 100};
		int[] nums = { 1, 3, 5, 70, 2, 4, 100, 7, 10, 6 };
		BestTimeToBuyAndSellStockIV test = new BestTimeToBuyAndSellStockIV();
		System.out.println(test.maxProfit(2, nums));
	}
}
