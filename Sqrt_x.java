package com.leetcode;

/**
 * 使用二分法求解一个数的平方根
 * @author yangfei
 */
public class Sqrt_x {
	public int sqrt(int x) {
		if(x < 0) {
			return -1;
		}
		if(x == 0 || x == 1) {
			return x;
		}
		int left = 1, right = x;
		int res = 0;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(mid == x / mid) {
				return mid;
			} else if (mid > x / mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
				res = mid;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int x = 5;
		Sqrt_x sqrt = new Sqrt_x();
		int res = sqrt.sqrt(x);
		System.out.println(res);
	}
}
