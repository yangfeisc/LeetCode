package com.leetcode;

/**
 * Suppose a sorted array is rotated at some pivot 
 * unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 
 * might become 4 5 6 7 0 1 2). Find the minimum element.
 * @author yangfei
 *
 */
public class FindMinimumInRotatedSortedArray {
	
	/**
	 * 方法一：
	 * 遍历整个数组，时间复杂度O(n)，空间复杂度O(1)
	 * @param num
	 * @return
	 */
//	public int findMin(int[] num) {
//		int min = num[0];
//		for(int i=1; i<num.length; i++) {
//        	min = min < num[i] ? min : num[i];
//        }
//		return min;
//    }
	
	/**
	 * 方法二：
	 * 时间复杂度O(n),空间复杂度O(1)
	 * @param num
	 * @return
	 */
//	public int findMin(int[] num) {
//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(num[0]);
//		for(int i=1; i<num.length; i++) {
//			if(num[i] < stack.peek()) {
//				stack.push(num[i]);
//			}
//		}
//		return stack.peek();
//	}
	
	/**
	 * 方法三：
	 * 二分查找，时间复杂度O(logn)
	 * @param num
	 * @return
	 */
	public int findMin(int[] num) {
		return binarySearch(num, 0, num.length-1);
	}
	
	public int binarySearch(int[] num, int begin, int end) {
		while(begin < end) {
			int mid = (end + begin)/2;
			if(num[mid] > num[mid+1])
				return num[mid+1];
			if(num[mid] > num[end])
				begin = mid + 1;
			else 
				end = mid;
		}
		return num[begin];
	}
	
	public static void main(String[] args) {
		int[] num = {2,3};
		FindMinimumInRotatedSortedArray fs = 
				new FindMinimumInRotatedSortedArray();
		System.out.println(fs.findMin(num));
	}
}
