package com.leetcode;

/**
 * Find the contiguous subarray within an array (containing at 
 * least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * @author yangfei
 *
 */
public class MaximumSubarray {
	/**
	 * 因为A中最大的连续和可能为负，所以在初始化的时候不能为0，应该是A[0].
	 * sum记录前面的子序列和与当前元素的大小关系
	 * result记录当前的最大子序列的和。
	 * @param A
	 * @return
	 */
	public int maxSubArray(int[] A) {
		if(A.length == 0)
			return 0;
		int sum = A[0];
		int result = A[0];
		for(int i=1; i<A.length; i++) {
			sum = Math.max(sum+A[i], A[i]);
			result = Math.max(result, sum);
		}
		return result;
    }
	
	public static void main(String[] args) {
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		MaximumSubarray ms = new MaximumSubarray();
		System.out.println(ms.maxSubArray(A));
	}
}
