package com.leetcode;

/**
 * 一个数组中有两个元素只出现一次，其他的均出现两次，找出这两个元素。
 * @author yangfei
 *
 */
public class FindTwoOnceElements {
	public int[] getOnceEle(int[] A) {
		if(A.length < 2)
			return A;
	
		int[] result = new int[2];  //要返回的结果
		int res = A[0];  //第一次对所有元素进行亦或操作结果
		for(int i=1; i<A.length; i++) {
			res ^= A[i];
		}
		int bitIndex = 0;
		for(int i=0; i<32; i++) {  //找出亦或结果为1的位。
			if((res>>i & 1) == 1) {
				bitIndex = i;
				break;
			}
		}
		for(int i=0; i<A.length; i++) { //根据bitIndex为1，将元素分为两组
			if((A[i] >> bitIndex & 1) == 1)
				result[0] ^= A[i];   //对应位为1，亦或得到的结果
			else
				result[1] ^= A[i];   //对应位为0，亦或得到的结果
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,1,3,2,4};
		FindTwoOnceElements fe = new FindTwoOnceElements();
		int[] result = fe.getOnceEle(A);
		System.out.println(result[0] + "\t" + result[1]);
	}
}
