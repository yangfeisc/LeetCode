package com.leetcode;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its 
 * index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * @author yangfei
 *
 */
public class SearchInRotatedSortedArray {
	 
	public int search(int[] A, int target) {
		int index = getMinIndex(A, 0, A.length-1);
		int result = binarySearch(A, 0, index-1, target);
		if(result == -1)
			return binarySearch(A, index, A.length-1, target);
		return result;
	}
	
	/**
	 * 二分查找获取特定区间内是否存在target
	 * @param A
	 * @param begin
	 * @param end
	 * @param target
	 * @return
	 */
	public int binarySearch(int[] A, int begin, int end, int target) {
		while(begin <= end) {
			int mid = (end + begin) / 2;
			if(A[mid] == target)
				return mid;
			if(target > A[mid])
				begin = mid + 1;
			else 
				end = mid - 1;
		}
		return -1;
	}
	
	/**
	 * 二分法获取数组中最小的元素对应的下表
	 * @param A
	 * @param begin
	 * @param end
	 * @return
	 */
	public int getMinIndex(int[] A, int begin, int end) {
		while(begin < end) {
			int mid = (end + begin) / 2;
			if(A[mid] > A[mid+1])
				return mid+1;
			if(A[mid] > A[end])
				begin = mid + 1;
			else 
				end = mid;
		}
		return begin;
	}
	
	public static void main(String[] args) {
		int[] A = {3, 1};
		SearchInRotatedSortedArray ss = new SearchInRotatedSortedArray();
		System.out.println(ss.search(A, 1));
	}
}
