package com.leetcode;

/**
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * @author yangfei
 *
 */
public class ImplementStrStr {
//	public int strStr(String haystack, String needle) {
//		if((haystack.isEmpty()&&!needle.isEmpty()) 
//				|| !haystack.contains(needle))
//			return -1;
//		if(needle.isEmpty())
//			return 0;
//
//		int len = haystack.length();
//		for(int i=0; i<len; i++) {
//			if(haystack.charAt(i) == needle.charAt(0)) {
//				int j = 1;
//				while(j<needle.length() && (i+j<len)) {
//					if(haystack.charAt(i+j) != needle.charAt(j))
//						break;
//					j++;
//				}
//				if(j == needle.length())
//					return i;
//			}
//		}
//		return -1;
//    }
	
	/**
	 * Implement with the KMP algorithm
	 * @param haystack
	 * @param needle
	 * @return
	 */
	public int strStr(String haystack, String needle) {
		if((haystack.isEmpty()&&!needle.isEmpty()) 
				|| !haystack.contains(needle))
			return -1;
		if(needle.isEmpty())
			return 0;
		//Calculate the next array
		int pLen = needle.length();
		int[] next = new int[pLen];
		next[0] = -1;
		int k = -1, j = 0;
		while(j < pLen - 1) {
			if(k == -1 || needle.charAt(j) == needle.charAt(k)) {
				k++;
				j++;
				next[j] = k;
				if(needle.charAt(j) == needle.charAt(k))
					next[j] = next[k];
			} else 
				k = next[k];
		}
		//match process
		int i = 0, m = 0;
		int sLen = haystack.length();
		while(i < sLen) {
			if(m == -1 || haystack.charAt(i) == needle.charAt(m)) {
				m++;
				i++;
			} else 
				m = next[m];
			if(m == pLen)
				return i - pLen;
		}
		return -1;
    }
	
	public static void main(String[] args) {
		String hay = "abcdef";
		String ned = "cde";
		ImplementStrStr iss = new ImplementStrStr();
		int result = iss.strStr(hay, ned);
		System.out.println(result);
	}
}
