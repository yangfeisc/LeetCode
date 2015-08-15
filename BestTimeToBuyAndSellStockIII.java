package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Say you have an array for which the i-th element is the price of 
 * a given stock on day i. Design an algorithm to find the maximum 
 * profit. You may complete at most two transactions.
 * Note: You may not engage in multiple transactions at the same time 
 * (i.e., you must sell the stock before you buy again).
 * @author yangfei
 *
 */
public class BestTimeToBuyAndSellStockIII {
	/**
	 * 首先建立一个数组maxBefore, maxBefore[i]保存i之前最大的收益，
	 * 然后逆序遍历找到i以后的最大收益与前面的maxBefore[i]求和。
	 * @param prices
	 * @return
	 */
	public int maxProfit(List<Integer> prices) {
        int len = prices.size();
        if (len < 2)
            return 0;
        int [] maxBefore = new int[len];
        int min = prices.get(0);
        //正序遍历：获取从第一天开始到第i天的最大收益
        for(int i=1; i<len; i++) {
            maxBefore[i] = Math.max(maxBefore[i-1], prices.get(i) - min);
            min = Math.min(min, prices.get(i));
        }
        int max = prices.get(len-1);
        int ret = 0;
        //逆序遍历，获取从第i天到最后一天的最大收益，然后与从第0天到第i天最大收益求和
        for (int i=len-2; i>=0; i--) {
            max = Math.max(prices.get(i), max);
            ret = Math.max(ret, max - prices.get(i) + maxBefore[i]);   
        }
        return ret;
    }
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(7);
		list.add(3);
		list.add(7);
		System.out.println(list);
		BestTimeToBuyAndSellStockIII bt = new BestTimeToBuyAndSellStockIII();
		System.out.println(bt.maxProfit(list));
	}
}
