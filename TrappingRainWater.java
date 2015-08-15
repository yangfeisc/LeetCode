package com.leetcode;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author yangfei
 * 
 */
public class TrappingRainWater {
	public int trap(int[] A) {
		int left = 0, right = A.length - 1;
		int result = 0, low = 0;
		while(left < right) {
			if(A[left] < A[right]) {
				low = Math.max(A[left], low);
				result += low - A[left];
				left++;
			} else {
				low = Math.max(A[right], low);
				result += low - A[right];
				right--;
			}
			System.out.println("low: " + low);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		TrappingRainWater tr = new TrappingRainWater();
		int result = tr.trap(A);
		System.out.println("total: " + result);
	}
}
