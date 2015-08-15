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
	 * ���Ƚ���һ������maxBefore, maxBefore[i]����i֮ǰ�������棬
	 * Ȼ����������ҵ�i�Ժ�����������ǰ���maxBefore[i]��͡�
	 * @param prices
	 * @return
	 */
	public int maxProfit(List<Integer> prices) {
        int len = prices.size();
        if (len < 2)
            return 0;
        int [] maxBefore = new int[len];
        int min = prices.get(0);
        //�����������ȡ�ӵ�һ�쿪ʼ����i����������
        for(int i=1; i<len; i++) {
            maxBefore[i] = Math.max(maxBefore[i-1], prices.get(i) - min);
            min = Math.min(min, prices.get(i));
        }
        int max = prices.get(len-1);
        int ret = 0;
        //�����������ȡ�ӵ�i�쵽���һ���������棬Ȼ����ӵ�0�쵽��i������������
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
