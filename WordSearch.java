package com.leetcode;

/**
 * Given a 2D board and a word, find if the word exists in the grid. The word
 * can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once. For example, Given board =[
 * ["ABCE"], ["SFCS"], ["ADEE"]] word = "ABCCED", -> returns true, word = "SEE",
 * -> returns true, word = "ABCB", -> returns false.
 * 
 * @author yangfei
 * 
 */
public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null)
			return false;
		if (word == null)
			return false;
		boolean found = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					found = checkAdjacent(board, i, j, word, 0);
				}
				if (found)
					break;
			}
			if (found)
				break;
		}
		return found;
	}

	public boolean checkAdjacent(char[][] board, int row, int column,
			String word, int start) {
		if (start == word.length() - 1)
			return true;
		char letter = board[row][column];
		board[row][column] = '*';

		// check up
		if (row > 0) {
			boolean up = false;
			if (board[row - 1][column] != '*'
					&& board[row - 1][column] == word.charAt(start + 1)) {
				up = checkAdjacent(board, row - 1, column, word, start + 1);
			}
			if (up)
				return true;
		}

		// check down
		if (row < board.length - 1) {
			boolean down = false;
			if (board[row + 1][column] != '*'
					&& board[row + 1][column] == word.charAt(start + 1)) {
				down = checkAdjacent(board, row + 1, column, word, start + 1);
			}
			if (down)
				return true;
		}

		// check left
		if (column > 0) {
			boolean left = false;
			if (board[row][column - 1] != '*'
					&& board[row][column - 1] == word.charAt(start + 1)) {
				left = checkAdjacent(board, row, column - 1, word, start + 1);
			}
			if (left)
				return true;
		}
		// check right
		if (column < board[0].length - 1) {
			boolean right = false;
			if (board[row][column + 1] != '*'
					&& board[row][column + 1] == word.charAt(start + 1)) {
				right = checkAdjacent(board, row, column + 1, word, start + 1);
			}
			if (right)
				return true;
		}

		board[row][column] = letter;
		return false;

	}

	public static void main(String[] args) {
		// char[][] board ={{'A','B','C','E'},{'S','F','C','S'},
		// {'A','D','E','E'}};
		char[][] board = { { 'C' } };
		WordSearch ws = new WordSearch();
		System.out.println(ws.exist(board, "CA"));
		// System.out.println(ws.exist(board, "SEE"));
		// System.out.println(ws.exist(board, "ABCB"));
	}
}
