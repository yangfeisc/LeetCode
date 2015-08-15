package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Say you have an array for which the i-th element is the price of 
 * a given stock on day i. Design an algorithm to find the maximum 
 * profit. You may complete as many transactions as you like (i.e., 
 * buy one and sell one share of the stock multiple times). However, 
 * you may not engage in multiple transactions at the same time (i.e., 
 * you must sell the stock before you buy again).
 * @author yangfei
 *
 */
public class BestTimeToBuyAndSellStockII {
	/**
	 * 所有的收益可以由序列中所有的上升序列的之间的叠加和产生
	 * @param prices
	 * @return
	 */
	public int maxProfit(List<Integer> prices) {
        if(prices.size() < 2)
        	return 0;
        int profit = 0;
        for(int i=1; i<prices.size(); i++) {
        	if(prices.get(i) > prices.get(i-1)) {
        		profit += (prices.get(i) - prices.get(i-1));
        	}
        }
        
        return profit;
    }
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(1);
		list.add(2);
		list.add(4);
		list.add(7);
		list.add(3);
		System.out.println(list);
		BestTimeToBuyAndSellStockII bt = new BestTimeToBuyAndSellStockII();
		System.out.println(bt.maxProfit(list));
	}
}
