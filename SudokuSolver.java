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
	 * ��д������ȱʧ����
	 * @param board--����
	 * @param n--�Ѿ���д�ĸ�����
	 */
	public boolean fillSudoku(char[][] board, int n) {
		if(n == 81)
			return true;
		int r = n % 9;  //��
		int c = n / 9;  //��
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
					board[r][c] = '.'; //����
				}
			}
		}
		return flag;
	}
	
	/**
	 * ��֤��������Ƿ���Ч��ÿ�У�ÿ�У�ÿ���Ź����ܳ�����������ͬ������
	 * @param board -- ��������
	 * @param r -- ��
	 * @param c -- ��
	 * @param d -- Ҫ���������
	 * @return
	 */
	public boolean validFill(char[][] board, int r, int c, int d) {
		char temp = (char)(d + '0');
		for(int i=0; i<9; i++) {
			//��֤��r�к͵�c���Ƿ������d��ͬ��Ԫ��
			if(board[r][i] == temp || board[i][c] == temp) {
				return false;
			}
		}
		
		//��֤(r,c)��Ӧ�ľŹ������Ƿ������d��ͬ��Ԫ��
		int sr = r / 3; //�����жϾŹ���λ��
		int sc = c / 3; //�����жϾŹ���λ��
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
