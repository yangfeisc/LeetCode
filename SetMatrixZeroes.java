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
	 * ����һ��ѭ������matrix�е�Ԫ�أ������ӦԪ��Ϊ0���򽫸�Ԫ�ض�Ӧ�������з�0Ԫ�ر��һ���ض���Ԫ�أ�
	 * ��ñ�ɵ�Ԫ�غ�ԭ����Ԫ�ز�ͬ��ѭ���������ٴ�ѭ�����ض�Ԫ��ȫ����Ϊ0.
	 * �ŵ㣺�����룬����Ҫ����Ŀռ䣬ʱ�临�Ӷ�O(n^2)��
	 * ȱ�㣺��matrix��Ԫ��û������ʱ���޷��ҵ�������ض�Ԫ�ء�
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
	 * ��������������������row��col���ֱ����ڱ���Ԫ��0��Ӧ���к��Լ��кţ�
	 * Ȼ����ݶ�Ӧ���к��Լ��кŽ���Ӧ���л����е�Ԫ�ر�Ϊ0��
	 * �ŵ㣺ʵ�ּ򵥣������񷽷�һ���ض�Ԫ�ء�
	 * ȱ�㣺��Ҫ�����µĿռ�O(m+n)
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
