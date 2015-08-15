package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Say you have an array for which the i-th element is the price 
 * of a given stock on day i. If you were only permitted to complete 
 * at most one transaction (i.e., buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * @author yangfei
 *
 */
public class BestTimeToBuyAndSellStock {
	/**
	 * 通过循环找出前面的最小值，以及当前的股票价格，找到与最小值之间的利润，并
	 * 判断这个利润与前面的最大利润的大小，并将两者之间大的作为maxProfit。
	 * @param prices
	 * @return
	 */
	public int maxProfit(List<Integer> prices) {
        if(prices.size() < 2)
        	return 0;
        int min = prices.get(0);
        int maxProfit = 0;
        for(int pr : prices) {
        	min = min<pr ? min : pr;
        	maxProfit = maxProfit>(pr - min) ? maxProfit : (pr-min);
        }
        return maxProfit;
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
		BestTimeToBuyAndSellStock bt = new BestTimeToBuyAndSellStock();
		System.out.println(bt.maxProfit(list));
	}
}
