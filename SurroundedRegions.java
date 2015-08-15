package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by
 * 'X'. A region is captured by flipping all 'O's into 'X's in that surrounded
 * region. For example, X X X X X O O X X X O X X O X X After running your
 * function, the board should be: X X X X X X X X X X X X X O X X
 * 
 * @author yangfei
 * 
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		if (board == null || board.length == 0)
			return;
		Queue<Integer> queue = new LinkedList<Integer>();
		int row = board.length, col = board[0].length;
		boolean visited[][] = new boolean[row][col];
		int dir[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; //四个方向
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				// 以下是标准的BFS搜索，用visitedPoints记录访问的O的位置
				if (board[i][j] == 'O' && !visited[i][j]) {
					boolean surounned = true;
					List<Integer> visitedO = new ArrayList<Integer>();
					queue.add(i * col + j); //记录O的位置
					visited[i][j] = true;
					while (!queue.isEmpty()) {
						int point = queue.poll();
						visitedO.add(point);
						int x = point / col;
						int y = point % col;
						for (int k = 0; k < 4; k++) {//判断上下左右情况
							int nextX = x + dir[k][0];
							int nextY = y + dir[k][1];
							if (nextX >= 0 && nextX < row 
									&& nextY >= 0 && nextY < col) {
								if (board[nextX][nextY] == 'O'
										&& !visited[nextX][nextY])
									queue.add(nextX * col + nextY);
								visited[nextX][nextY] = true;
							} else {
								surounned = false;
							}
						}
					}

					//如果当前遍历到的O是被包围的
					if (surounned) {
						for (int p : visitedO)
							board[p/col][p%col] = 'X';
					}
				}
			}
		}
	}

	public void solve1(char[][] board) {
		if (board == null || board.length == 0)
			return;
		int row = board.length;
		int col = board[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (board[i][j] == 'O') {
					// if(i==0 || i==row-1 || j==0 || j==col-1) {
					// board[i][j] = 'T';
					// break;
					// }
					BFS(i, j, board, row, col);
				}
			}
		}
	}

	public boolean BFS(int i, int j, char[][] board, int row, int col) {
		if (board[i][j] == 'X' || i == 0 || i == row - 1 || j == 0
				|| j == col - 1)
			return true;
		else if (board[i][j] == 'O') {
			boolean left = BFS(i - 1, j, board, row, col);
			System.out.println(left + "\t" + i + "\t" + j);
			boolean right = BFS(i + 1, j, board, row, col);
			boolean up = BFS(i, j - 1, board, row, col);
			boolean low = BFS(i, j + 1, board, row, col);
			if (left && right && up && low) {
				board[i][j] = 'X';
				return true;
			} else
				board[i][j] = 'T';
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' },
				{ 'X', 'X', 'O', 'X' }, { 'X', 'O', 'X', 'X' } };
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
		System.out.println();
		SurroundedRegions sr = new SurroundedRegions();
		sr.solve(board);
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
}
