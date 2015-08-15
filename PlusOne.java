package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits, 
 * plus one to the number. The digits are stored such that the most 
 * significant digit is at the head of the list.
 * @author yangfei
 *
 */
public class PlusOne {
	public int[] plusOne(int[] digits) {
        int carry = 0;  //½øÎ»
        List<Integer> list = new ArrayList<Integer>();
        int temp = digits[digits.length-1] + 1;
        if(temp >= 10) {
        	list.add(temp % 10);
        	carry = 1;
        } else {
        	list.add(temp);
        	carry = 0;
        }
        for(int i=digits.length-2; i>=0; i--) {
        	int tt = digits[i] + carry;
        	if(tt >= 10) {
        		list.add(tt % 10);
        		carry = 1;
        	} else {
        		list.add(tt);
        		carry = 0;
        	}
        }
        if(carry == 1)
        	list.add(carry);
        int[] result = new int[list.size()];
        int j=0;
        for(int i=list.size()-1; i>=0; i--)
        	result[j++] = list.get(i);
        return result;
    }
	
	public static void main(String[] args) {
		int[] A = {9,9,9};
		PlusOne po = new PlusOne();
		int[] result = po.plusOne(A);
		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + "\t");
		}
	}
}
