package com.leetcode;

/**
 * 统计一个整型数字每位出现的次数，如果这个数出现3次，则对应的位中1的个数就是3的倍数，统计完所有数
 * 后对每位对3取余得到这一位的值。
 * @author yangfei
 */
public class SingleNumber2 {
	public int singleNumber(int[] A) {
		if (A.length == 0) {
			return -1;
		}
		if (A.length == 1) {
			return A[0];
		}
		int[] bits = new int[32];
		int a = 0;
		for(int i=0; i<32; i++) {
			for(int j=0; j<A.length; j++) {
				bits[i] += (A[j] >> i) & 1;
			}
			a = a | ((bits[i]%3)<<i);
		}
		return a;
	}
	public static void main(String[] args) {
		SingleNumber2 sn2 = new SingleNumber2();
		int[] A = {2, 0, 0, 5};
		int a = sn2.singleNumber(A);
		System.out.println(a);
	}
}
