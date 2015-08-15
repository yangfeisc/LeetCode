package com.leetcode;

/**
 * 给定两个有序的整型数组，找出两个数组和第K大的值
 * @author yangfei
 *
 */
public class KthSumOfTwoArray {
	public int getKthSum(int[] A, int[] B, int K) {
		if(A.length == 0 && B.length == 0)
			return 0; 
		if(A.length == 0) 
			return K>1 ? B[K-1] : 0;
		if(B.length == 0)
			return K>1 ? A[K-1] : 0;
		if(K == 0)
			return 0;
		int m = A.length - 1;
		int n = B.length - 1;
		int min = A[0] + B[0], max = A[m] + B[n];
		while(min < max) {
			int mid = (max + min) >>> 1;
			int count = Count(mid, A, m, B, n);
			if(count >= K) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}
	
	/**
	 * 计算A和B的和中比value大的元素的个数有多少
	 * @param value
	 * @return
	 */
	public int Count(int value, int[] A, int m, int[] B, int n) {
		int count = 0;
		for(int i=0, j=n; i<=m && j>=0;) {
			if(A[i] + B[j] > value) {
				count += m - i + 1;  //因为A[p]+B[j]>value, i<p<=m
				j--;
			} else 
				i++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] A = {};
		int[] B = {2,4,6,8};
		KthSumOfTwoArray ks = new KthSumOfTwoArray();
		System.out.println(ks.getKthSum(A, B, 3));
		System.out.println(ks.getKthSum(A, B, 7));
		System.out.println(ks.getKthSum(A, B, 11));
		System.out.println(ks.getKthSum(A, B, 15));
		System.out.println(ks.getKthSum(A, B, 20));
	}
}
