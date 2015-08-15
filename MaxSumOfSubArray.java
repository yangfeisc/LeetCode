package com.leetcode;

/**
 * This class uses to calculate the largest sum of a 
 * continuous subArray.
 * @author yangfei
 *
 */
public class MaxSumOfSubArray {
	/**
	 * The elements of the array A are double.
	 * 前i个元素中，最大总和子数组要不在前i-1个元素中（将其存为maxSum），
	 * 要不其结束位置为i（将其存为maxEndingHere）。
	 * @param A
	 * @return
	 */
	public double maxSum(double[] A) {
		double maxEndingHere = 0;
		double maxSum = 0;
		for(int i=0; i<A.length; i++) {
			double temp = maxEndingHere + A[i];
			maxEndingHere = temp>0 ? temp:0;
			maxSum = maxSum>temp ? maxSum:temp;
		}
		return maxSum;
	}
	
	public static void main(String[] args) {
		double[] A = {1,2,3,-4,-3,4};
		MaxSumOfSubArray ms = new MaxSumOfSubArray();
		double result = ms.maxSum(A);
		System.out.println(result);
	}
}
