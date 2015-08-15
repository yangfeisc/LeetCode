package com.leetcode;

/**
 * Given a sorted array and a target value, return the index 
 * if the target is found. If not, return the index where it 
 * would be if it were inserted in order. You may assume no 
 * duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * @author yangfei
 *
 */
public class SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
        if(nums.length==0 || target<nums[0])
            return 0;
        if(target > nums[nums.length-1])
            return nums.length;
        int begin = 0;
        int end = nums.length - 1;
        while(begin < end) {
            int mid = (begin + end) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target) 
                end = mid;
            else 
                begin = mid + 1;
        }
        return begin;
    }
	
	public static void main(String[] args) {
		int[] A = {1,2,3};
		SearchInsertPosition si = new SearchInsertPosition();
		System.out.println(si.searchInsert(A, 4));
	}
}
