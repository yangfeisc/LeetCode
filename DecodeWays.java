package com.leetcode;

/**
 * A message containing letters from A-Z is being encoded to 
 * numbers using the following mapping:
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * Given an encoded message containing digits, determine the 
 * total number of ways to decode it.
 * For example, Given encoded message "12", it could be decoded 
 * as "AB" (1 2) or "L" (12). 
 * The number of ways decoding "12" is 2.
 * @author yangfei
 *
 */
public class DecodeWays {
	/**
	 * DP
	 */
	public int numDecodings(String s) {
		if (s.length() == 0 || s.charAt(0) == '0')
			return 0;
		if (s.length() == 1)
			return 1;
		int pre = Character.getNumericValue(s.charAt(0));
		int cur = Character.getNumericValue(s.charAt(1));
		int result = 1, preResult = 1, prePre = 1;
		if (cur == 0) {
			if (pre <=0 || pre > 2)
				return 0;
			preResult = 1;
		} else if (pre == 1 || (pre == 2 && cur <= 6))
			preResult = 2;
		else
			preResult = 1;
		if (s.length() == 2)
			return preResult;
		pre = cur;
		for (int i = 2; i < s.length(); i++) {
			cur = Character.getNumericValue(s.charAt(i));
			if (cur == 0) {
				if (pre <=0 || pre > 2)
					return 0;
				result = prePre;
			} else if (pre == 1 || (pre == 2 && cur <= 6))
				result = preResult + prePre;
			else
				result = preResult;
			pre = cur;
			prePre = preResult;
			preResult = result;
		}
		return result;
	}
}
