package com.leetcode;

/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * The array may contain duplicates.
 * @author yangfei
 *
 */
public class FindMinimumInRotatedSortedArrayII {
	public int findMin(int[] num) {
		return binarySearch(num, 0, num.length-1);
    }
	
	/**
	 * 找出两半中最小的，然后比较得到更小的
	 * @param num
	 * @param begin
	 * @param end
	 * @return
	 */
	public int binarySearch(int[] num, int begin, int end) {
		if(begin == end)
			return num[begin];
		int mid = (begin + end) / 2;
		if(num[mid] > num[mid+1])
			return num[mid+1];
		int left = binarySearch(num, begin, mid);
		int right = binarySearch(num, mid + 1, end);
		return left<right ? left : right;
	}
	
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII fs = new 
				FindMinimumInRotatedSortedArrayII();
		int[] num = {3,3,3,3,3,3,1,3};
		int result = fs.findMin(num);
		System.out.println(result);
	}
}
