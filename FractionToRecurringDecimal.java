package com.leetcode;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, 
 * return the fraction in string format. If the fractional part is repeating, 
 * enclose the repeating part in parentheses.
 * For example, Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * @author yangfei
 *
 */
public class FractionToRecurringDecimal {
	public String fractionToDecimal(int numerator, int denominator) {
	    StringBuilder result = new StringBuilder();
	    String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
	    long num = Math.abs((long) numerator);
	    long den = Math.abs((long) denominator);
	    result.append(sign);
	    result.append(num / den);
	    long res = num % den;
	    if (res == 0)
	        return result.toString();
	    result.append(".");
	    HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
	    while (!hashMap.containsKey(res)) {
	        hashMap.put(res, result.length());
	        result.append(10 * res / den);
	        res = 10 * res % den;
	    }
	    int index = hashMap.get(res);
	    result.insert(index, "(");
	    result.append(")");
	    return result.toString().replace("(0)", "");
	}
	
	public static void main(String[] args) {
		FractionToRecurringDecimal fr = new FractionToRecurringDecimal();
		System.out.println(fr.fractionToDecimal(-2147483648, -1999));
	}
}
