package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all 
 * elements of the matrix in spiral order.
 * For example, Given the following matrix:
 * [ [ 1, 2, 3 ],
 *   [ 4, 5, 6 ], 
 *   [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * @author yangfei
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if(matrix == null || matrix.length == 0)
			return list;
		int m = matrix.length;
		int n = matrix[0].length;
		int u = m/2, v=n/2;
		if(m == 1 && n == 1)
			list.add(matrix[0][0]);
		else if(m == 1)
			for(int i=0; i<n; i++)
				list.add(matrix[0][i]);
		else if(n == 1)
			for(int i=0; i<m; i++)
				list.add(matrix[i][0]);
		else {
			if(m % 2 == 0)
				u = m / 2 - 1;
			if(n % 2 == 0)
				v = n / 2 - 1;
			for(int i=0,j=0; i<=u && j<=v; i++,j++) {
				for(int p=j; p<n-j; p++) {  //从左到右读取上行
					list.add(matrix[i][p]);
				}
				for(int q=i+1; q<m-i && n>=2*j+1; q++) { //从上到下读取右列
					list.add(matrix[q][n-j-1]);
				}
				for(int p=n-j-2; p>=j && m>2*i+1; p--) { //从右到左读取下行
					list.add(matrix[m-i-1][p]);
				}
				for(int q=m-i-2; q>i; q--) { //从下到上读取左列
					list.add(matrix[q][j]);
				}
			}
		}
		return list;
    }
	
	public static void main(String[] args) {
//		int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[][] m = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
		SpiralMatrix sm = new SpiralMatrix();
		List<Integer> list = sm.spiralOrder(m);
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + "\t");
		}
	}
}
