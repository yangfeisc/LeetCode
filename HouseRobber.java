package com.leetcode;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint 
 * stopping you from robbing each of them is that adjacent houses have 
 * security system connected and it will automatically contact the 
 * police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of 
 * money of each house, determine the maximum amount of money you 
 * can rob tonight without alerting the police.
 * @author yangfei
 *
 */
public class HouseRobber {
	
	/**
	 * 超时
	 * @param num
	 * @return
	 */
//	public int rob(int[] num) {
//        if(num.length <= 0)
//        	return 0;
//        if(num.length == 1)
//        	return num[0];
//        int max = select(num, 0);
//        
//        return max;
//    }
//	
//	public int select(int[] num, int b) {
//		int max = 0;
//		if(b > num.length - 1) {
//			return max;
//		}
//		int selected = num[b] + select(num, b+2);
//		int unselect = select(num, b+1);
//		max = selected>unselect ? selected : unselect;
//		return max;
//	}
	
	/**
	 * 动态规划，时间复杂度O(n)，空间复杂度O(n).
	 * @param num
	 * @return
	 */
//	public int rob(int[] num) {
//		int[][] dp = new int[num.length+1][2];
//		for(int i=1; i<=num.length; i++) {
//			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
//			dp[i][1] = num[i-1] + dp[i-1][0];
//		}
//		return Math.max(dp[num.length][0], dp[num.length][1]);
//	}
	
	public int rob(int[] num) {
		int Max = 0;
		int preMax = 0;
		for(int i=1; i<=num.length; i++) {
			int temp = preMax;
			preMax = Max>preMax ? Max : preMax;
			Max = num[i-1] + temp;
		}
		return Max>preMax ? Max : preMax;
	}
	
	public static void main(String[] args) {
		int[] num = {3,2,5,7,8,9};
		HouseRobber hr = new HouseRobber();
		System.out.println(hr.rob(num));
	}
}
