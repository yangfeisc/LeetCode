package com.leetcode;

/**
 * Given a sorted array of integers, find the starting 
 * and ending position of a given target value. Your 
 * algorithm's runtime complexity must be in the order 
 * of O(log n). If the target is not found in the array, 
 * return [-1, -1].
 * For example,Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * @author yangfei
 *
 */
public class SearchForARange {
	/**
	 * 方法一：使用两次二分查找，分别确定左边界和右边界
	 * @param A
	 * @param target
	 * @return
	 */
//	public int[] searchRange(int[] A, int target) {
//		int lb = 0;
//		int le = A.length - 1;
//		int mid;
//		//确定左边界
//		while(lb <= le) {
//			mid = (lb + le) / 2;
//			if(target > A[mid]) {
//				lb = mid + 1;
//			} else {
//				le = mid - 1;
//			}
//		}
//		int rb = 0;
//		int re = A.length - 1;
//		//确定右边界
//		while(rb <= re) {
//			mid = (rb + re) / 2;
//			if(target >= A[mid]) {
//				rb = mid + 1;
//			} else {
//				re = mid - 1;
//			}
//		}
//		int[] result = {-1, -1};
//		if(lb <= re) {
//			result[0] = lb;
//			result[1] = re;
//		}
//		return result;
//    }
	
	/**
	 * 方法二：使用递归
	 * @param A
	 * @param target
	 * @return
	 */
	public int[] searchRange(int[] A, int target) {
		int[] result = {-1, -1};
		binarySearch(A, target, 0, A.length-1, result);
		return result;
	}
	
	public void binarySearch(int[] A, int target, int begin,
			int end, int[] result) {
		int mid;
		while(begin <= end) {
			mid = (begin + end) / 2;
			if(target == A[mid]) {
				result[0] = (result[0] >= 0) ? 
						Math.min(result[0], mid) : mid;
				result[1] = Math.max(result[1], mid);
				binarySearch(A, target, begin, mid-1, result);//左边缘
				binarySearch(A, target, mid+1, end, result); //右边缘
				return;
			} else if(target > A[mid]) {
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] A = {1,1};
		SearchForARange sr = new SearchForARange();
		int[] result = sr.searchRange(A, 1);
		System.out.println(result[0] + "\t" + result[1]);
	}
}
