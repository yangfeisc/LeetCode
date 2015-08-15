package com.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class RomanToInteger {
	public int romanToInt(String s) {
		char[] RDict = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
		int[] NumberDict = {1, 5, 10, 50, 100, 500, 1000};
		int result = 0;
		Map<Character, Integer> dict = new TreeMap<Character, Integer>();
		int len = NumberDict.length;
		for(int i=len-1; i>=0; i--) {
			dict.put(RDict[i], NumberDict[i]);
		}
		int size = s.length();
		for(int i=size-1; i>=0; i--) {
			if(i == size - 1) {
				result += dict.get(s.charAt(i));
				continue;
			}
			if(dict.get(s.charAt(i)) >= dict.get(s.charAt(i+1)))
				result += dict.get(s.charAt(i));
			else
				result -=dict.get(s.charAt(i));
			
		}
		return result;
    }
	
	public static void main(String[] args) {
		String s = "MMCMCCXI";
		RomanToInteger rti = new RomanToInteger();
		System.out.println(rti.romanToInt(s));
	}
}
