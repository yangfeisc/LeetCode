package com.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence 
 * where each word is a valid dictionary word. Return all such possible sentences. 
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"]. 
 * A solution is ["cats and dog", "cat sand dog"].
 * @author yangfei
 * 
 */
public class WordBreakII {


	/**
	 * 判断词典中是否包含str的后缀，如果包含后缀，那么str可能可以用dict分割，否则肯定不行。
	 * @param dict
	 * @param str
	 * @return
	 */
	private boolean containsSuffix(Set<String> dict, String str) {
		for (int i = 0; i < str.length(); i++) {
			if (dict.contains(str.substring(i)))
				return true;
		}
		return false;
	}

	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> result = new LinkedList<>();
		if (dict.contains(s))
			result.add(s);
		for (int i = 1; i < s.length(); i++) {
			String left = s.substring(0, i);  //左半部分字符串
			String right = s.substring(i);    //右半部分字符串
			if (dict.contains(left) && containsSuffix(dict, right)) {
				for (String ss : wordBreak(right, dict)) {
					result.add(left + " " + ss);
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String s = "catsanddog";
		Set<String> set = new HashSet<String>();

		set.add("cat");
		set.add("cats");
		set.add("and");
		set.add("sand");
		set.add("dog");
		// set.add("aaaaaa");
		// set.add("aaaaaaa");
		// set.add("aaaaaaaa");
		// set.add("aaaaaaaaa");
		WordBreakII wb = new WordBreakII();

		List<String> list = wb.wordBreak(s, set);
		System.out.println("************************");
		for (String str : list)
			System.out.println(str);
	}
}
