package com.leetcode;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] 
 * is rotated to [5,6,7,1,2,3,4].
 * Note: Try to come up as many solutions as you can, there are 
 * 	at least 3 different ways to solve this problem.
 * 	Do it in-place with O(1) extra space
 * 
 * Algorithm: rotate all the array, then rotate a sub array based on
 * the input k, then rotate the other elements.
 * @author yangfei
 *
 */
public class RotateArray {
	public void rotate(int[] nums, int k) {
		if(nums.length == 0 || nums.length == 1)
			return;
		if(k > nums.length)
		    k -= nums.length;
		subRotate(nums, 0, nums.length);
		subRotate(nums, 0, k);
		subRotate(nums, k, nums.length);
    }
	
	public void subRotate(int[] nums, int begin, int end) {
		for(int i=begin,j=0; i<(end+begin)/2; i++,j++) {
			int temp = nums[i];
			nums[i] = nums[end-j-1];
			nums[end-j-1] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1,2,3};
		RotateArray ra = new RotateArray();
		ra.rotate(nums, 1);
		for(int t : nums)
			System.out.print(t + "\t");
	}
}
