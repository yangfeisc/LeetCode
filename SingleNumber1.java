package com.leetcode;

public class SingleNumber1 {
	public int singleNumber(int[] A) {
        if(A.length == 0) {
            return -1;
        }
        if(A.length == 1) {
            return A[0];
        }
        int a = A[0];
        for(int i=1; i<A.length; i++) {
            a = a ^ A[i];
        }
        return a;
    }
	
	public static void main(String[] args) {
		int[] A = {2,2,1};
		SingleNumber1 sn = new SingleNumber1();
		int C = sn.singleNumber(A);
		System.out.println(C);
	}
}
