package com.leetcode;

public class RemoveElement {
	public int removeElement(int[] A, int elem) {
        int len = A.length;
        int index = len - 1;
        for(int i=0; i<len; i++) {
        	if(A[i] == elem) {
        		A[i] = A[index];
        		A[index] = Integer.MIN_VALUE;
        		index--;
        		i--;
        	}
        }
        int result = 0;
        for(int i = len-1; i>=0; i--) {
        	if(A[i] > Integer.MIN_VALUE) {
        		result = i + 1;
        		return result;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] A = new int[]{1,2,5,4,5,5,7,5,3};
		int elem = 5;
		RemoveElement re = new RemoveElement();
		int len = re.removeElement(A, elem);
		System.out.println("\nresult: " + len);
	}
}
