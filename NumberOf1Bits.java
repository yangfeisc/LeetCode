package com.leetcode;

/**
 * Write a function that takes an unsigned integer and returns the number 
 * of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 
 * 00000000000000000000000000001011, so the function should return 3.
 * @author yangfei
 *
 */
public class NumberOf1Bits {
	// you need to treat n as an unsigned value
	/**
	 * 如果n为2147483648，结果会出错
	 * @param n
	 * @return
	 */
    public int hammingWeight(int n) {
        int result = 0;
    	while(n > 0) {
    		if((n&1) == 1)
    			result++;
    		n = n >> 1;
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		int n = 11 ;
		NumberOf1Bits no = new NumberOf1Bits();
		System.out.println(no.hammingWeight(n));
	}
}
