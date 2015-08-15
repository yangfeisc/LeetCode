package com.leetcode;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * @author yangfei
 *
 */
public class FactorialTrailingZeroes {
	/**
	 * 从1到n之间我们会发现：
	 * 每隔5会出现一个0，例如5,10,15,20,25,...；
	 * 每隔5*5会出两个0，例如25,50,75,...。因为这些数会分解出两个5，又因为第一种情况包含第二
	 * 种情况，所以每隔5*5相当于又多了一个0；
	 * 同理，每隔5*5*5又会多一个0.
	 * 因此我们只需要计算1~n之间有多少个5的倍数，25的倍数，125的倍数等，然后求和就是结果。
	 * 因为pow(5,k)必须小于n，所以i循环的时候只需要到Math.log(n)/Math.log(5)即可。
	 * @param n
	 * @return
	 */
	public int trailingZeroes(int n) {
		int count = 0;
		for(int i=1; i<=Math.log(n)/Math.log(5); i++) {
			int factor = (int) Math.pow(5, i);
			count += n / factor;
		}
		
		return count;
    }
	
	public static void main(String[] args) {
		int n = 5;
		FactorialTrailingZeroes ft = new FactorialTrailingZeroes();
		System.out.println(ft.trailingZeroes(n));
	}
}
