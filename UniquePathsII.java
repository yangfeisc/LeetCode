package com.leetcode;

/**
 * Follow up for "Unique Paths": Now consider if some obstacles are added to the
 * grids. How many unique paths would there be? An obstacle and empty space is
 * marked as 1 and 0 respectively in the grid. For example, There is one
 * obstacle in the middle of a 3x3 grid as illustrated below. [[0,0,0], [0,1,0],
 * [0,0,0] ] The total number of unique paths is 2.
 * 
 * @author yangfei
 * 
 */
public class UniquePathsII {
	/**
	 * 使用一个m*n的矩阵保存到当前位置的路径数，到(i,j)位置的路径数等于(i-1,j)和(i,j-1)的路径数之和，
	 * 不断填写矩阵，最后返回(m-1,n-1)对应的数字即为所求。
	 * 时间复杂度O(m*n)，空间复杂度O(m*n)
	 * @param obstacleGrid
	 * @return
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid.length == 0 || obstacleGrid[0][0] == 1)
			return 0;
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] result = new int[m][n];
		result[0][0] = 1;
		for (int i = 1; i < n; i++) {
			if (obstacleGrid[0][i] == 0)
				result[0][i] = result[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			if (obstacleGrid[i][0] == 0)
				result[i][0] = result[i - 1][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1)
					result[i][j] = 0;
				else {
					result[i][j] = result[i - 1][j] + result[i][j - 1];
				}
			}
		}
		return result[m - 1][n - 1];
	}

	// public int uniquePath(int m, int n) {
	// if(m == 1 || n == 1)
	// return 1;
	// long result = 1; //避免溢出
	// for(int i=1; i<=n-1; i++) {
	// result *= m - 1 + i;
	// result /= i;
	// }
	// return (int)result;
	// }

	/**
	 * 采用递归的方式，从左上角到右下角的路径等于两个方向路径和，如果遇到1，就认为这个方向不通。 超时
	 * 
	 * @param grid
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePath(int[][] grid, int m, int n) {
		if (m == grid.length - 1) {
			for (int i = 0; i < n; i++) {
				if (grid[m][i] == 1)
					return 0;
			}
			return 1;
		}
		if (n == grid[0].length - 1) {
			for (int i = 0; i < m; i++) {
				if (grid[i][n] == 1)
					return 0;
			}
			return 1;
		}
		int right = 0, low = 0;
		if (m < grid.length - 1 && grid[m + 1][n] != 1) {
			low = uniquePath(grid, m + 1, n);
		}
		if (n < grid[0].length - 1 && grid[m][n + 1] != 1) {
			right = uniquePath(grid, m, n + 1);
		}
		return right + low;
	}

	public static void main(String[] args) {
		// int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
		// int[][] grid = {{1}};
		// int[][] grid = {{0,1},{1,0}};
		int[][] grid = { { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 0, 0 },
				{ 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
		UniquePathsII up = new UniquePathsII();
		int res = up.uniquePathsWithObstacles(grid);
		System.out.println(res);
	}
}
