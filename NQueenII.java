package com.leetcode;

/**
 * Follow up for N-Queens problem.Now, instead outputting board 
 * configurations, return the total number of distinct solutions.
 * @author yangfei
 *
 */
public class NQueenII {
	int result = 0;
	int[] A;
	public int totalNQueens(int n) {
        A = new int[n];
        nQueen(0, n);
        return result;
    }
	
	public void nQueen(int cur, int n) {
		if(cur == n)
			result++;
		else {
			for(int i=0; i<n; i++) {
				A[cur] = i;
				if(valid(cur)) {
					nQueen(cur+1, n);
				}
			}
		}
	}
	
	public boolean valid(int cur) {
		for(int i=0; i<cur; i++) {
			if(A[i] == A[cur] ||
					Math.abs(A[i]-A[cur]) == cur - i)
				return false;
				
		}
		return true;
	}
	
	public static void main(String[] args) {
		NQueenII nq = new NQueenII();
		System.out.println(nq.totalNQueens(4));
	}
}
