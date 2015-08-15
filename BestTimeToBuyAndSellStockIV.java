package com.leetcode;

import java.util.Arrays;

/**
 * Say you have an array for which the i-th element 
 * is the price of a given stock on day i. Design an 
 * algorithm to find the maximum profit. You may 
 * complete at most k transactions.
 * Note: You may not engage in multiple transactions at 
 * the same time (i.e. you must sell the stock before you buy again).
 * @author yangfei
 *
 */
public class BestTimeToBuyAndSellStockIV {
	public int maxProfit(int k, int[] prices) {
		int n = prices.length;     
		if (n < 2 || k <= 0)
			return 0;
		if(k >= n/2) {  //当k>=n/2时，此时的结果就相当于不管买多少次的最优情况。
			int result = 0;
			for(int i=1; i<n; i++) {
				if(prices[i] > prices[i-1])
					result += prices[i] - prices[i-1];
			}
			return result;
		}
		int[] local = new int[k + 1];  //局部最优
		int[] global = new int[k + 1]; //全局最优
		for (int i = 0; i < prices.length - 1; i++) {
			int profit = prices[i + 1] - prices[i];  //前后两天的利润，可为负
			for (int j = k; j >= 1; j--) {
				//局部最优是比较前一天并少交易一次的全局最优加上大于0的差值和前一天的局部最优加上差值后的较大者
				local[j] = Math.max(global[j-1] + (profit > 0 ? profit : 0),
						local[j] + profit);
				//全局最优是局部最优和前一天的全局最优的较大者
				global[j] = Math.max(local[j], global[j]);
			}
			System.out.println("###########");
			System.out.println(Arrays.toString(local));
			System.out.println(Arrays.toString(global));
		}
		return global[k];
	}
	
	public static void main(String[] args) {
		int[] list = {3,1,2,4,7,3,7,9};
		BestTimeToBuyAndSellStockIV bt = new BestTimeToBuyAndSellStockIV();
		System.out.println(bt.maxProfit(3, list));
	}
}
