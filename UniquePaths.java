package com.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below). The robot can only 
 * move either down or right at any point in time. The robot 
 * is trying to reach the bottom-right corner of the grid 
 * (marked 'Finish' in the diagram below). 
 * How many possible unique paths are there?
 * m and n will be at most 100
 * @author yangfei
 *
 */
public class UniquePaths {
	/**
	 * 递归，向右一步对应的路径数+向下一步对应的路径数
	 * 超时
	 * @param m
	 * @param n
	 * @return
	 */
//	public int uniquePaths1(int m, int n) {
//        if(m == 1 || n == 1)
//        	return 1;
//		return uniquePaths1(m-1, n) + uniquePaths1(m, n-1);
//    }
	
	/**
	 * 利用组合原理，机器人必须经过(m+n-2)步走到终点，其中向右m-1步，向下n-1步
	 * 所以可以使用从(m+n-2)个数中取(m-1)个数的可能作为最后的结果
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths2(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
		long result = 1; //避免溢出
		for(int i=1; i<=n-1; i++) {
			result *= m - 1 + i;
			result /= i;
		}
		return (int)result;
	}
	
	/**
	 * 使用一个m*n的矩阵保存到当前位置的路径数，到(i,j)位置的路径数等于(i-1,j)和(i,j-1)的路径数之和，
	 * 不断填写矩阵，最后返回(m-1,n-1)对应的数字即为所求。
	 * 时间复杂度O(m*n)，空间复杂度O(m*n)
	 * @return
	 */
	public int uniquePaths3(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
		int[][] result = new int[m][n];
		result[0][0] = 1;
		for (int i = 1; i < n; i++) {
			result[0][i] = result[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			result[i][0] = result[i - 1][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				result[i][j] = result[i - 1][j] + result[i][j - 1];
			}
		}
		return result[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths2(10, 10));
		System.out.println(up.uniquePaths3(10, 10));
	}
}
