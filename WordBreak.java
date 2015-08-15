package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be 
 * segmented into a space-separated sequence of one or more dictionary words.
 * For example, given s = "leetcode", dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * @author yangfei
 *
 */
public class WordBreak {
//	Hashtable<Integer, List<String>> table = new Hashtable<Integer, List<String>>();
//	public boolean wordBreak(String s, Set<String> dict) {
//		if(s == null || s.equals("")) {
//			return true;
//		}
//		if(s != null && s.equals("") && dict.isEmpty()) {
//			return false;
//		}
//		
//		//将词典中的单词根据长度进行hash。
//		for(String word : dict) {
//			int len = word.length();
//			if(table.containsKey(len)) {
//				table.get(len).add(word);
//			} else {
//				List<String> list = new ArrayList<String>();
//				list.add(word);
//				table.put(len, list);
//			}
//		}
//		
//		boolean flag = contain(table, s);
//		if(flag) 
//			return true;
//		return false;
//	}
//	
//	public boolean contain(Hashtable<Integer, List<String>> table, String str) {
//		if(str.equals("")) {
//			return true;
//		}
//		boolean f = false;
//		Set<Integer> keyset = table.keySet();
//		for(int key : keyset) {
//			if(str.length() >= key) {
//				String subStr = str.substring(0, key);
//				System.out.println(subStr);
//				if(table.get(key).contains(subStr)) {
//					str = str.substring(key);
//					System.out.println("str: " + str);
//					f = contain(table, str);
//					if(f)
//						break;
//				} 
//			}
//		}
//		if(f) 
//			return true;
//		return false;
//	}
	
	public boolean wordBreak(String s, Set<String> dict){
		int len = s.length();
	    boolean[] arrays = new boolean[len+1];
	    arrays[0] = true;
	    for (int i = 1; i <= len; ++i){
	    	for (int j = 0; j < i; ++j){
	    		if (arrays[j] && dict.contains(s.substring(j, i))){
	    			arrays[i] = true;
	    			break;
	    		}
	    	}
	    }
	    return arrays[len];
	}
	
	public static void main(String[] args) {
		String s = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		Set<String> set = new HashSet<String>();

		set.add("a");
		set.add("aa");
		set.add("aaa");
		set.add("aaaa");
		set.add("aaaaa");
		set.add("aaaaaa");
		set.add("aaaaaaa");
		set.add("aaaaaaaa");
		set.add("aaaaaaaaa");
		WordBreak wb = new WordBreak();
		
		boolean f = wb.wordBreak(s, set);
		System.out.println(f);
	}
}
