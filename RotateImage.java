package com.leetcode;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * Follow up: Could you do this in-place?
 * @author yangfei
 *
 */
public class RotateImage {
	
	/**
	 * 方法一：使用临时List保存每一列的值，然后将每一列倒序输出到二维数组中。
	 * 空间复杂度O(n^2)，时间复杂度O(n^2)
	 * @param matrix
	 */
//	public void rotate(int[][] matrix) {
//		List<int[]> col = new ArrayList<>();
//		int i, j;
//		for(i=0; i<matrix[0].length; i++) {
//			int[] temp = new int[matrix.length];
//			for(j=0; j<matrix.length; j++) {
//				temp[j] = matrix[j][i];
//			}
//			col.add(temp);
//		}
//		i = 0;
//		for(int[] raw : col) {
//			j = 0;
//			for(int m=raw.length-1; m>=0; m--) {
//				matrix[i][j++] = raw[m]; 
//			}
//			i++;
//		}
//    }

	/**
	 * 根据旋转90的规则，先将矩阵进行转置，然后交换列即可
	 * 时间复杂度O(n^2)，空间复杂度O(1)
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		int N = matrix.length;
		int i, j;
		//转置
		for(i=0; i<N; i++) {
			for(j=i+1; j<N; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
		//行变换
		for(i=0; i<N/2; i++) {
			for(j=0; j<N; j++) {
				int temp = matrix[j][i];
				matrix[j][i] = matrix[j][N-1-i];
				matrix[j][N-1-i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		RotateImage ri = new RotateImage();
		ri.rotate(matrix);
		for(int i=0; i<matrix.length; i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}
