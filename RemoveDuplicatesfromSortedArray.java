package com.leetcode;

/**
 * Return the length of the processed array.
 * Based on the returned length, the program 
 * should make sure the pre-length elements 
 * in the A is no duplicate.
 * No extra space is needed.
 * 
 * 获取数组的长度所需要的时间为O(1),在外面将数组长度提前赋值给另
 * 外的变量会降低程序的效率。
 * @author yangfei
 */
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] A) {
		if(A.length == 0)
			return 0;
		int begin = 1;
		for(int i=1; i<A.length; i++) {
			if(A[i] != A[i-1]) {
				A[begin++] = A[i];
			} 
		}
		return begin;
    }
	
	public static void main(String[] args) {
		int[] A = new int[]{1,1,1,2,3};
		RemoveDuplicatesfromSortedArray rd = new RemoveDuplicatesfromSortedArray();
		int len = rd.removeDuplicates(A);
		System.out.println(len);
	}
}
