package com.leetcode;

import java.util.Arrays;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n^2 in spiral order.
 * For example, Given n = 3, You should return the following matrix:
 * [ [ 1, 2, 3 ],
 *   [ 8, 9, 4 ],
 *   [ 7, 6, 5 ]
 * ]
 * @author yangfei
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
		if(n == 0)
        	return result;
		int k = n / 2;
		if(n % 2 == 0)
			k = n/2 - 1;
		int element = 0;
		for(int i=0, j=0; i<=k && j<=k; i++,j++) {
			for(int p=j; p<n-j; p++) { //从左向右填充上行
				result[i][p] = (++element);
			}
			for(int q=i+1; q<n-i && n>2*j+1; q++) { //从上向下填充右列
				result[q][n-j-1] = (++element);
			}
			for(int p=n-2-j; p>=j; p--) { //从右向左填充下行
				result[n-i-1][p] = (++element);
			}
			for(int q=n-i-2; q>i && n>2*i+1; q--) { //从下向上填充左列
				result[q][j] = (++element);
			}
		}
        return result;
    }
	
	public static void main(String[] args) {
		SpiralMatrixII sm = new SpiralMatrixII();
		int n = 3;
		for(int i=0; i<n; i++)
			System.out.println(Arrays.toString(sm.generateMatrix(n)[i]));
			
	}
}
