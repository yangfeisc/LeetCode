package com.leetcode;

/**
 * Note: This is an extension of House Robber. After robbing those houses on that 
 * street, the thief has found himself a new place for his thievery so that he will 
 * not get too much attention. This time, all houses at this place are arranged in 
 * a circle. That means the first house is the neighbor of the last one. Meanwhile, 
 * the security system for these houses remain the same as for those in the previous 
 * street.
 * Given a list of non-negative integers representing the amount of money of each 
 * house, determine the maximum amount of money you can rob tonight without alerting 
 * the police.
 * @author yangfei
 *
 */
public class HouseRobberII {
	public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int firstMax = 0;  //consider the first element
        int preMax = 0;
        for(int i=1; i<nums.length; i++) {
            int tmp = preMax;
            preMax = preMax>firstMax ? preMax : firstMax;
            firstMax = nums[i-1] + tmp;
        }
        firstMax = firstMax>preMax ? firstMax : preMax;
        
        int tailMax = 0;  //consider the tail element
        preMax = 0;
        for(int i=2; i<=nums.length; i++) {
            int tmp = preMax;
            preMax = preMax>tailMax ? preMax : tailMax;
            tailMax = nums[i-1] + tmp;
        }
        tailMax = tailMax>preMax ? tailMax : preMax;
        return firstMax>tailMax ? firstMax : tailMax;
    }
}
