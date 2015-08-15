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
		if(k >= n/2) {  //��k>=n/2ʱ����ʱ�Ľ�����൱�ڲ�������ٴε����������
			int result = 0;
			for(int i=1; i<n; i++) {
				if(prices[i] > prices[i-1])
					result += prices[i] - prices[i-1];
			}
			return result;
		}
		int[] local = new int[k + 1];  //�ֲ�����
		int[] global = new int[k + 1]; //ȫ������
		for (int i = 0; i < prices.length - 1; i++) {
			int profit = prices[i + 1] - prices[i];  //ǰ����������󣬿�Ϊ��
			for (int j = k; j >= 1; j--) {
				//�ֲ������ǱȽ�ǰһ�첢�ٽ���һ�ε�ȫ�����ż��ϴ���0�Ĳ�ֵ��ǰһ��ľֲ����ż��ϲ�ֵ��Ľϴ���
				local[j] = Math.max(global[j-1] + (profit > 0 ? profit : 0),
						local[j] + profit);
				//ȫ�������Ǿֲ����ź�ǰһ���ȫ�����ŵĽϴ���
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
