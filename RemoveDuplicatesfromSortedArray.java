package com.leetcode;

/**
 * Return the length of the processed array.
 * Based on the returned length, the program 
 * should make sure the pre-length elements 
 * in the A is no duplicate.
 * No extra space is needed.
 * 
 * ��ȡ����ĳ�������Ҫ��ʱ��ΪO(1),�����潫���鳤����ǰ��ֵ����
 * ��ı����ή�ͳ����Ч�ʡ�
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
