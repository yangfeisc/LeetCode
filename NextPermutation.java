package com.leetcode;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically 
 * next greater permutation of numbers. If such arrangement is not possible, it must 
 * rearrange it as the lowest possible order (i.e., sorted in ascending order). The 
 * replacement must be in-place, do not allocate extra memory. Here are some examples. 
 * Inputs are in the left-hand column and its corresponding outputs are in the right-hand column. 
 * 1,2,3 ¡ú 1,3,2
 * 3,2,1 ¡ú 1,2,3
 * 1,1,5 ¡ú 1,5,1
 * 
 * Algorithm:find out the largest index of element to exchange, for example,
 * if num[i]>num[j] (i>j) is the largest index of j that exists this pair,
 * the index to exchange is j, and exchange num[i] and num[j], then sort the
 * subarray from j to the array tail. 
 * @author yangfei
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] num) {
        //find out the index to exchange
        int index = -1;
        int exch = num.length;
        for(int i=num.length-1; i>0; i--) {
        	for(int j=i-1; j>=0; j--) {
        		if(num[i] > num[j] && j > index) {
        			index = j;
        			exch = i;
        		}
        	}
        	if(index > i)
        		break;
        }
        if(index > -1) {
        	int temp = num[exch];
        	num[exch] = num[index];
        	num[index] = temp;
        	Arrays.sort(num, index+1, num.length);
        } else {
        	Arrays.sort(num);
        }
    }
	
	public static void main(String[] args) {
		int[] num = {1,1,5};
		NextPermutation np = new NextPermutation();
		np.nextPermutation(num);
		for(int i : num) 
			System.out.print(i + "\t");
		System.out.println();
	}
}
