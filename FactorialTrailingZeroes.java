package com.leetcode;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * @author yangfei
 *
 */
public class FactorialTrailingZeroes {
	/**
	 * ��1��n֮�����ǻᷢ�֣�
	 * ÿ��5�����һ��0������5,10,15,20,25,...��
	 * ÿ��5*5�������0������25,50,75,...����Ϊ��Щ����ֽ������5������Ϊ��һ����������ڶ�
	 * �����������ÿ��5*5�൱���ֶ���һ��0��
	 * ͬ��ÿ��5*5*5�ֻ��һ��0.
	 * �������ֻ��Ҫ����1~n֮���ж��ٸ�5�ı�����25�ı�����125�ı����ȣ�Ȼ����;��ǽ����
	 * ��Ϊpow(5,k)����С��n������iѭ����ʱ��ֻ��Ҫ��Math.log(n)/Math.log(5)���ɡ�
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
