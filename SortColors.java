package com.leetcode;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort 
 * them so that objects of the same color are adjacent, with the 
 * colors in the order red, white and blue. Here, we will use the 
 * integers 0, 1, and 2 to represent the color red, white, and blue 
 * respectively.
 * Note: You are not suppose to use the library's sort function for 
 * this problem.
 * @author yangfei
 *
 */
public class SortColors {
	public void sortColors(int[] A) {
		if(A.length == 0)
            return;
        int[] color = new int[3];
        for(int i=0; i<A.length; i++) {
            color[A[i]]++;
        }
        for(int i=0; i<A.length; i++) {
            if(i < color[0])
                A[i] = 0;
            else if(i < color[0] + color[1])
                A[i] = 1;
            else 
                A[i] = 2;
        }
    }
	
	public static void main(String[] args) {
		int[] A = {0,1,2,0,1,2};
		SortColors sc = new SortColors();
		sc.sortColors(A);
		System.out.println(Arrays.toString(A));
	}
}
