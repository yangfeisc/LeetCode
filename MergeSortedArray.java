package com.leetcode;

/**
 * 首先将A的元素依次拷贝到后半部分，这样前半部分为空，然后作为新排序的存储空间。
 * @author yangfei
 */
public class MergeSortedArray {
	
	public void merge(int A[], int m, int B[], int n) {
		if(m == 0) {
			for(int i=0; i<m+n; i++) {
				A[i] = B[i];
			}
		} else {
			int index = A.length - 1;
			for(index=A.length-1; index>=n; index--) {
				A[index] = A[index-n];
			}
		
			int ai = index+1; 
			int bj = 0;
			int i=0;
			for(ai=index+1, bj=0; ai<A.length && bj<n;) {
				if(A[ai]<=B[bj]) {
					A[i] = A[ai];
					ai++;
					i++;
				} else {
					A[i] = B[bj];
					bj++;
					i++;
				}
			}
			if(ai < A.length) {
				for(int k=ai; k<A.length; k++) {
					A[i++] = A[k];
				}
			}
			if(bj < n) {
				for(int k=bj; k<n; k++) {
					A[i++] = B[k];
				}
			}
		}
		
		for(int p=0; p<A.length; p++) {
			System.out.print(A[p] + "\t");
		}
	}
	
	public static void main(String[] args) {
		MergeSortedArray msa = new MergeSortedArray();
		
		int m = 1, n = 1;
		int[] A = new int[m+n];
		A[0] = 2;
//		A[1] = 1;
//		A[2] = 1;
//		A[3] = 7;
//		A[4] = 10;
//		int[] B = {2, 6, 7};
		int[] B ={3};
		msa.merge(A, m, B, n);
	}
}
