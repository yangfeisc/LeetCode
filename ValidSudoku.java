package com.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Determine if a Sudoku is valid.
 * 
 * @author yangfei
 * 
 */
public class ValidSudoku {
//	public boolean isValidSudoku(char[][] board) {
//		// 验证行
//		for (int i = 0; i < 9; i++) {
//			int[] num = new int[9];
//			for (int j = 0; j < 9; j++) {
//				if (board[i][j] != '.') {
//					if(num[board[i][j]-'1'] > 0)
//						return false;
//					num[board[i][j]-'1']++;
//				}
//			}
//		}
//		// 验证列
//		for (int i = 0; i < 9; i++) {
//			int[] num = new int[9];
//			for (int j = 0; j < 9; j++) {
//				if (board[j][i] != '.') {
//					if(num[board[j][i]-'1'] > 0)
//						return false;
//					num[board[j][i]-'1']++;
//				}
//			}
//		}
//		// 验证小的九宫格
//		for(int i=0; i<9; i+=3) {
//			for(int j=0; j<9; j+=3) {
//				int[] num = new int[9];
//				for(int row=0; row<3; row++) {
//					for(int column=0; column<3; column++) {
//						if (board[i+row][j+column] != '.') {
//							if(num[board[i+row][j+column]-'1'] > 0)
//								return false;
//							else 
//								num[board[i+row][j+column]-'1']++;
//						}
//					}
//				}
//			}
//		}
//		
//		return true;
//	}
	
	public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        if(row == 0)
            return true;
        int col = board[0].length;
        if(col == 0)
            return true;
        Set<Character> set = new TreeSet<Character>();
        //判断行是否满足
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(board[i][j] != '.') {
                    if(set.contains(board[i][j])) {
                    	return false;
                    }
                    else 
                        set.add(board[i][j]);
                }
            }
            set = new TreeSet<Character>();
        }
        //判断列是否满足
        for(int i=0; i<col; i++) {
            for(int j=0; j<row; j++) {
                if(board[j][i] != '.') {
                    if(set.contains(board[j][i])) {
                    	return false;
                    }
                    else 
                        set.add(board[j][i]);
                }
            }
            set = new TreeSet<Character>();
        }
        //判断小的九宫格是否满足
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                for(int m=3*i; m<3*(i+1); m++) {
                    for(int n=3*j; n<3*(j+1); n++) {
                    	if(board[m][n] != '.') {
                    		if(set.contains(board[m][n])) {
                    			System.out.println("3333");
                    			return false;
                    		}
                    		else 
                    			set.add(board[m][n]);
                    	}
                    }
                    System.out.println(Arrays.toString(set.toArray()));
                    set = new TreeSet<Character>();
                }   
            }
        }
        
        return true;
    }

	public static void main(String[] args) {
		char[][] in = { { '.', '8', '7', '6', '5', '4', '3', '2', '1' },
						{ '2', '.', '.', '.', '.', '.', '.', '.', '.' },
						{ '3', '.', '.', '.', '.', '.', '.', '.', '.' },
						{ '4', '.', '.', '.', '.', '.', '.', '.', '.' },
						{ '5', '.', '.', '.', '.', '.', '.', '.', '.' },
						{ '6', '.', '.', '.', '.', '.', '.', '.', '.' },
						{ '7', '.', '.', '.', '.', '.', '.', '.', '.' },
						{ '8', '.', '.', '.', '.', '.', '.', '.', '.' },
						{ '9', '.', '.', '.', '.', '.', '.', '.', '.' } };
		ValidSudoku vs = new ValidSudoku();
		boolean flag = vs.isValidSudoku(in);
		System.out.println(flag);
	}
}
