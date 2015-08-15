package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced 
 * to get t. All occurrences of a character must be replaced with 
 * another character while preserving the order of characters. No two 
 * characters may map to the same character but a character may map to 
 * itself.
 * For example, Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * @author yangfei
 *
 */
public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if(s == null && t == null)
			return true;
		if(s == null || t == null || s.length() != t.length())
			return false;
		Map<Character, Character> map = new HashMap<>();
		int index = 0;
		while(index < s.length()) {
			char c = s.charAt(index);
			if(map.containsKey(c) && (map.get(c) != t.charAt(index)))
				return false;
			else if(!map.containsKey(c) && (map.containsValue(t.charAt(index))))
				return false;
			map.put(c, t.charAt(index));
			index++;
		}
		return true;
    }
	
	public static void main(String[] args) {
		String s1 = "aba", t1 = "baa";
		String s2 = "foo", t2 = "bar";
		String s3 = "paper", t3 = "title";
		String s4 = "qwertyuiopaaasdfghjkl;'\\zxcvbnm,./";
		String t4 = "',.pyfgcrl/=aoeuidhtns-\\;qjkxbmwvz";
		IsomorphicStrings is = new IsomorphicStrings();
		System.out.println(is.isIsomorphic(s1, t1));
		System.out.println(is.isIsomorphic(s2, t2));
		System.out.println(is.isIsomorphic(s3, t3));
		System.out.println(is.isIsomorphic(s4, t4));
	}
}
