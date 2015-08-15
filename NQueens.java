package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n��n 
 * chessboard such that no two queens attack each other.
 * Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' 
placement, where 'Q' and '.' both indicate a queen and an empty space 
respectively.
 * @author yangfei
 *
 */
public class NQueens {
	private List<String[]> result = new ArrayList<String[]>();
	private int[] A;  //ÿ�з��õ�Queen��Ӧ��������A[1]=2��ʾ��һ�е�2�з���һ��Queen
	public List<String[]> solveNQueens(int n) {
        A = new int[n];
        nQueen(0, n);
        return result;
    }
	/**
	 * ����Queen
	 * @param placed
	 * @param n
	 */
	public void nQueen(int placed, int n) {
		if(placed == n)
			addResult(n);
		else {
			for(int i=0; i<n; i++) {
				A[placed] = i;
				if(valid(placed))
					nQueen(placed+1, n);
			}
		}
	}
	
	/**
	 * ��֤���õ�Queen�Ƿ���Ч������ͬ�У���A[i] != A[place]
	 * �����ڶԽ����ϣ�A[i]-A[place] != place-i
	 * @param place
	 * @return
	 */
	public boolean valid(int place) {
		for(int i=0; i<place; i++) {
			if(A[i] == A[place] 
					|| Math.abs(A[i]-A[place])==place-i)
				return false;
		}
		return true;
	}
	
	/**
	 * ��ӽ�����������
	 * @param n
	 */
	public void addResult(int n) {
		 String[] tem = new String[n];  
	     for(int i=0; i<n; i++){  
	    	 StringBuilder sb = new StringBuilder();  
	         for(int j=0; j<n; j++){  
	        	 if(A[i] == j) 
	        		 sb.append('Q');  
	             else 
	            	 sb.append('.');  
	         }  
	         tem[i] = sb.toString();  
	     }  
	     result.add(tem); 
	}
	
	public static void main(String[] args) {
		NQueens nq = new NQueens();
		List<String[]> result = nq.solveNQueens(12);
		for(String[] res : result) {
			System.out.println(Arrays.toString(res));
		}
	}
}
