package com.leetcode;

import java.util.Arrays;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number 
 * of islands. An island is surrounded by water and is formed by connecting 
 * adjacent lands horizontally or vertically. You may assume all four 
 * edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * @author yangfei
 *
 */
public class NumberOfIslands {
	/**
	 * 采用DFS进行遍历，遇到‘1’就变成‘2’，并将同一个岛的‘1’都变成‘2’，然后继续遍历找到‘1’。
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0)
			return 0;
		int m = grid.length;
		int n = grid[0].length;
		int result = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(grid[i][j] == '1') {
					result++;
					DFS(grid, i, j);
				}
			}
		}
		for(int i=0; i<m; i++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		return result;
	}
	
	public void DFS(char[][] grid, int i, int j) {
		if(grid[i][j] != '1')
			return;
		grid[i][j] = '2';
		if(i > 0)
			DFS(grid, i-1, j);
		if(j > 0)
			DFS(grid, i, j-1);
		if(i < grid.length - 1)
			DFS(grid, i+1, j);
		if(j < grid[0].length - 1)
			DFS(grid, i, j+1);
	}
	
	public static void main(String[] args) {
		char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},
				{'0','0','1','0','0'},{'0','0','0','1','1'}};
//		char[][] grid = {{'1','0','1','1','1'},{'1','0','1','0','1'},
//				{'1','1','1','0','1'},{'0','0','0','1','1'}};
//		char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},
//				{'1','1','0','0','0'},{'0','0','0','0','0'}};
//		char[][] grid = {{'1','0','1','1','0','1'}};
//		char[][] grid = {{'1','1','1'},{'0','1','0'},{'1','1','1'}};
		NumberOfIslands nol = new NumberOfIslands();
		System.out.println(nol.numIslands(grid));
	}
}
