package com.leetcode;

/**
 * Given a m x n grid filled with non-negative numbers, find a path 
 * from top left to bottom right which minimizes the sum of all 
 * numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * @author yangfei
 *
 */
public class MinimumPathSum {
	/**
	 * 递归，每次找到达这个点的前一个点的最短路径，然后加上这个元素的值。
	 * 超时。
	 * @param grid
	 * @return
	 */
//	public int minPathSum(int[][] grid) {
//		if(grid.length <= 0)
//			return 0;
//		int M = grid.length - 1;  //行
//		int N = grid[0].length - 1;  //列
//		return minSum(grid, M, N);
//	}
//	
//	public int minSum(int[][] grid, int m, int n) {
//		int result = 0;
//		if(m==0 && n==0)
//			return grid[0][0];
//		if(m == 0) {
//			for(int i=0; i<=n; i++)
//				result += grid[0][i];
//			return result;
//		}
//		if(n == 0) {
//			for(int i=0; i<=m; i++)
//				result += grid[i][0];
//			return result;
//		}
//			
//		int left = minSum(grid, m, n-1) + grid[m][n-1];
//		int top = minSum(grid, m-1, n) + grid[m-1][n];
//		result = left<top ? left : top;
//		return result + grid[m][n];
//	}
	
	/**
	 * 使用动态规划，分配一个m*n的表，表中每个位置记录grid到达这个位置的最小路径和。
	 * @param grid
	 * @return
	 */
	public int minPathSum(int[][] grid) {
		int M = grid.length;
		int N = grid[0].length;
		int[][] DP = new int[M][N];
		DP[0][0] = grid[0][0];
		for(int i=1; i<M; i++) {
			DP[i][0] = DP[i-1][0] + grid[i][0];
		}
		for(int j=1; j<N; j++) {
			DP[0][j] = DP[0][j-1] + grid[0][j];
		}
		for(int i=1; i<M; i++) {
			for(int j=1; j<N; j++) {
				DP[i][j] = Math.min(DP[i][j-1], DP[i-1][j]) + grid[i][j];
			}
		}
		return DP[M-1][N-1];
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1,2,3,4}};
		MinimumPathSum mp = new MinimumPathSum();
		System.out.println(mp.minPathSum(grid));
	}
}
