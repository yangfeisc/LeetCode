package com.leetcode;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * @author yangfei
 *
 */
public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		if(A.length==0 || (A.length==1 && A[0] != 1))
			return 1;
		int i = 0;
		for(i=0; i<A.length;) {
			if(A[i] <= 0 || A[i] == i+1 
					|| A[i]>A.length-1 || A[i] == A[A[i]-1])
				i++;
			else {
				int temp = A[A[i] - 1];
				A[A[i]-1] = A[i];
				A[i] = temp;
			}
		}
		for(i=0; i<A.length; i++) {
			if(A[i] != i + 1)
				return i+1;
		}
		return i+1; 
    }
	
	public static void main(String[] args) {
		int[] A = {3,2};
		FirstMissingPositive fm = new FirstMissingPositive();
		System.out.println(fm.firstMissingPositive(A));
	}
}
