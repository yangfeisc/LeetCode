package com.leetcode;

import java.util.Arrays;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
 * Do it in place.
 * Follow up: Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * @author yangfei
 *
 */
public class SetMatrixZeroes {
	
	/**
	 * 方法一：循环遍历matrix中的元素，如果对应元素为0，则将该元素对应的行列中非0元素变成一个特定的元素，
	 * 最好变成的元素和原来的元素不同，循环结束后，再次循环将特定元素全部改为0.
	 * 优点：容易想，不需要额外的空间，时间复杂度O(n^2)；
	 * 缺点：当matrix的元素没有限制时，无法找到合理的特定元素。
	 * @param matrix
	 */
	public void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)
        	return;
        int n = matrix[0].length;
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(matrix[i][j] == 0) {
        			for(int p=0; p<m; p++) {
        				if(matrix[p][j] != 0)
        					matrix[p][j] = Integer.MAX_VALUE;
        			}
        			for(int q=0; q<n; q++) {
        				if(matrix[i][q] != 0)
        					matrix[i][q] = Integer.MAX_VALUE;
        			}
        		}
        	}
        }
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(matrix[i][j] == Integer.MAX_VALUE)
        			matrix[i][j] = 0;
        	}
        }
    }
	
	/**
	 * 方法二：申请两个数组row和col，分别用于保存元素0对应的行号以及列号；
	 * 然后根据对应的行号以及列号将相应的行或者列的元素变为0；
	 * 优点：实现简单，不用像方法一找特定元素。
	 * 缺点：需要分配新的空间O(m+n)
	 * @param matrix
	 */
	public void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        if(m == 0)
        	return;
        int n = matrix[0].length;
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(matrix[i][j] == 0) {
        			row[i] = 1;
        			col[j] = 1;
        		}
        	}
        }
        for(int i=0; i<m; i++) {
        	if(row[i] == 1) {
        		for(int j=0; j<n; j++)
        			matrix[i][j] = 0;
        	}
        }
        for(int i=0; i<n; i++) {
        	if(col[i] == 1) {
        		for(int j=0; j<m; j++)
        			matrix[j][i] = 0;
        	}
        }
    }
	
	public static void main(String[] args) {
		int[][] m = {{1,2,3},{4,0,5},{6,7,8}};
		SetMatrixZeroes sz = new SetMatrixZeroes();
		sz.setZeroes1(m);
		for(int i=0; i<m.length; i++) {
			System.out.println(Arrays.toString(m[i]));
		}
	}
}
