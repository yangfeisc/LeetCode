package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle 
 * containing all ones and return its area.
 * @author yangfei
 *
 */
public class MaximalRectangle {
	/**
	 * 将原问题转化为对Largest Rectangle in Histogram问题，
	 * 首先对矩阵每行中每个位置按列对应的1的个数，如果这个元素为0，不变，否则等于上一行对应位置元素+1.
	 * @param matrix
	 * @return
	 */
	public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
        	return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i=1; i<row; i++) {
        	for(int j=0; j<col; j++) {
        		if(matrix[i][j] == '0')
        			continue;
        		matrix[i][j] += matrix[i-1][j]-'0';
        	}
        }
        for(int i=0; i<row; i++)
        	System.out.println(Arrays.toString(matrix[i]));
        
        Stack<Integer> stack = new Stack<>();
        int maxRect = 0;
        //将每行按Largest Rectangle in Histogram方案计算
        for(int i=0; i<row; i++) {
        	stack = new Stack<>();
        	for(int j=0; j<=col; j++) {
        		int h = (j==col ? 0 : matrix[i][j]-'0');
        		if(stack.isEmpty() || h >= matrix[i][stack.peek()])
        			stack.push(j);
        		else {
        			while(!stack.isEmpty() && h<matrix[i][stack.peek()]-'0') {
        				int index = stack.pop();
        				int hei = matrix[i][index] - '0';
        				maxRect = Math.max(maxRect, 
        						hei*(stack.isEmpty()? j : (j-1-stack.peek())));
        			}
        			stack.push(j);
        		}
        	}
        }
        return maxRect;
    }
	
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','1','0'}, {'0','1','1','1','1'},
				{'0','0','1','1','1'}, {'1','0','1','1','1'}};
		MaximalRectangle mr = new MaximalRectangle();
		System.out.println(mr.maximalRectangle(matrix));
	}
	
	
}
