package com.leetcode;

/**
 * ͳ��һ����������ÿλ���ֵĴ�����������������3�Σ����Ӧ��λ��1�ĸ�������3�ı�����ͳ����������
 * ���ÿλ��3ȡ��õ���һλ��ֵ��
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
