package com.leetcode;

import java.math.BigInteger;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * @author yangfei
 *
 */
public class MultiplyStrings {
	
	/**
	 * BigInteger可以表示任意长度的整数
	 * @param num1
	 * @param num2
	 * @return
	 */
	public String multiply(String num1, String num2) {
		BigInteger b1 = new BigInteger(num1);
		BigInteger b2 = new BigInteger(num2);
		BigInteger res = b1.multiply(b2);
		return res.toString();
    }
	
	public static void main(String[] args) {
		String str1 = "12";
		String str2 = "1";
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply(str1, str2));
	}
}
