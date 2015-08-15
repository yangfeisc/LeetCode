package com.leetcode;

/** 
 * 注意：数组中元素为能跳的最大距离，因此从前考虑会造成结果不准确
 * 直观的解法：从后向前依次遍历，而且每次找能到结果点的最大距离的点
 * @author yangfei
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		if(A.length == 0) {
			return true;
		}
		if(A.length == 1) {
			return true;
		}
		
		return recursion(A, A.length-1);
    }
	
	
	public boolean recursion(int[] A, int n) {
		if (n <= 0) {
			return true;
		} else {
			for(int i = n-1; i>=0; i--) {
				if(i + A[i] >= n) {
					return recursion(A, n-1);
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] A = {2, 0};
		boolean flag = jg.canJump(A);
		System.out.println(flag);
	}
}
