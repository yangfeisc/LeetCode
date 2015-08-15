package com.leetcode;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * 会影响，因为如果有重复的话，那么没法通过二分法找最小值，例如
 * 2,1,2,2,2,2和2,2,2,2,1,2，这两种情况不能通过判断mid和0或者len-1对应的元素比较找最小值。
 * 如果不能通过二分法找到最小值，那么就没法将数组分为两段，那么就没法通过二分进行搜索。
 * Write a function to determine if a given target is in the array.
 * @author yangfei
 *
 */
public class SearchInRotatedSortedArrayII {
	/**
	 * 直接遍历，时间复杂度为O(n)
	 * @param A
	 * @param target
	 * @return
	 */
	public boolean dirSearch(int[] A, int target) {
        for(int i=0; i<A.length; i++) {
        	if(A[i] == target)
        		return true;
        }
        return false;
    }
	
	public boolean search(int[] A, int target) {
        int begin = 0, end = A.length - 1;
		while(begin <= end) {
			int mid = (end + begin) / 2;
			if(A[mid] == target)
				return true;
			//因为target！=A[mid]，所以不会等于任何与A[mid]相同的元素
			while(A[begin] == A[mid] && begin < mid) 
				begin++;
			while(A[mid] == A[end] && mid < end)
				end--;
			//如果begin=mid=end,说明数组中元素相同，且都不会等于target
			if(begin == mid && mid == end)
				return false;
			if(A[begin] <= target && target < A[mid])
				end = mid;
			else if(A[mid] < target && target <= A[end])
				begin = mid + 1;
			else if(A[begin] > A[mid])
				end = mid;
			else 
				begin = mid + 1;
		}
        return false;
    }
	
	public static void main(String[] args) {
		int[] A = {5,1,3};
		SearchInRotatedSortedArrayII si = new SearchInRotatedSortedArrayII();
		System.out.println(si.search(A, 3));
	}
}
