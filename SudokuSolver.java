package com.leetcode;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * @author yangfei
 *
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		fillSudoku(board, 0);
    }
	
	/**
	 * 填写数独中缺失数字
	 * @param board--数独
	 * @param n--已经填写的格子数
	 */
	public boolean fillSudoku(char[][] board, int n) {
		if(n == 81)
			return true;
		int r = n % 9;  //行
		int c = n / 9;  //列
		boolean flag = false;
		if(board[r][c] != '.') {
			flag = fillSudoku(board, n+1);
		} else {
			for(int i=1; i<10; i++) {
				if(validFill(board, r, c, i)) {
					board[r][c] = (char)(i + '0');
					flag = fillSudoku(board, n+1);
					if(flag) {
						break;
					}
					board[r][c] = '.'; //回溯
				}
			}
		}
		return flag;
	}
	
	/**
	 * 验证填的数字是否有效：每行，每列，每个九宫格不能出现两个以上同样的数
	 * @param board -- 数独矩阵
	 * @param r -- 行
	 * @param c -- 列
	 * @param d -- 要填入的数字
	 * @return
	 */
	public boolean validFill(char[][] board, int r, int c, int d) {
		char temp = (char)(d + '0');
		for(int i=0; i<9; i++) {
			//验证第r行和第c列是否存在与d相同的元素
			if(board[r][i] == temp || board[i][c] == temp) {
				return false;
			}
		}
		
		//验证(r,c)对应的九宫格中是否存在与d相同的元素
		int sr = r / 3; //按行判断九宫格位置
		int sc = c / 3; //按列判断九宫格位置
		for(int i=3*sr; i<3*(sr+1); i++) {
			for(int j=3*sc; j<3*(sc+1); j++) {
				if(board[i][j] == temp) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] in = { { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
						{ '.', '4', '.', '3', '.', '.', '.', '.', '.' },
						{ '.', '.', '.', '.', '.', '4', '.', '.', '2' },
						{ '8', '.', '.', '.', '.', '.', '.', '2', '.' },
						{ '.', '.', '2', '.', '7', '.', '.', '.', '.' },
						{ '.', '1', '5', '.', '.', '.', '.', '.', '.' },
						{ '.', '.', '.', '.', '.', '2', '.', '.', '.' },
						{ '.', '2', '.', '9', '.', '.', '.', '.', '.' },
						{ '.', '.', '4', '.', '.', '.', '.', '.', '.' } };
		SudokuSolver ss = new SudokuSolver();
		ss.solveSudoku(in);
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				System.out.print(in[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
