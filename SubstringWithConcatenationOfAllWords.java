package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given a string, S, and a list of words, L, 
 * that are all of the same length. Find all starting 
 * indices of substring(s) in S that is a concatenation 
 * of each word in L exactly once and without any intervening 
 * characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * @author yangfei
 *
 */
public class SubstringWithConcatenationOfAllWords {
	
	/**
	 * 超时
	 * @param S
	 * @param L
	 * @return
	 */
//	public List<Integer> findSubstring(String S, String[] L) {
//		if(S == null || L.length == 0)
//			return new ArrayList<Integer>();
//		
//		int totalLength = L.length * L[0].length();
//		if(S.length() < totalLength)
//			return new ArrayList<Integer>();
//		
//		List<Integer> result = new ArrayList<Integer>();
//		int step = L[0].length();
//		for(int i=0; i<=S.length()-totalLength; i++) {
//			if(match(S.substring(i, i+totalLength), L, step)) {
//				result.add(i);
//			}
//		}
//		
//		return result;
//	}
//	
//	public boolean match(String str, String[] L, int step) {
//		String[] copy = L.clone();
//		for(int i=0; i<=str.length()-step; i+=step) {
//			boolean flag = false;
//			for(int j=0; j<copy.length; j++) {
//				System.out.println(i+"\t" + str.substring(i, i+step) + "\t" + copy[j] + "\tj:" + j);
//				if(str.substring(i, i+step).equals(copy[j])) {
//					flag = true;
//					copy[j] = "";
//					break;
//				}
//				System.out.println("new: " + str.substring(i, i+step) + "\t" + copy[j] + "\tj:" + j);
//			}
//			if(!flag)  
//				return false;
//		}
//		return true;
//	}
	
	/**
	 * 使用两个Map，分别保存L对应的单词，以及S中相应长度可能产生的单词
	 * 然后判断两个map是否相同，如果相同就记录相应的index
	 * @param S
	 * @param L
	 * @return
	 */
	public List<Integer> findSubstring(String S, String[] L) {
	    List<Integer> result = new ArrayList<Integer>();
	    if (L.length == 0 || L[0].isEmpty() || L[0].length()*L.length > S.length()) 
	        return result;
	    int size = L[0].length();
	    Map<String, Integer> LMap = new HashMap<String, Integer>();
	    for (String w : L) {
	    	LMap.put(w, !LMap.containsKey(w) ? 1 : LMap.get(w)+1);
	    }
	    for (int i = 0; i <= S.length()-size*L.length; i++) {
	        if (LMap.containsKey(S.substring(i, i+size))) {
	            Map<String, Integer> SMap = new HashMap<String, Integer>();
	            for (int j = 0; j < L.length; j++) {
	                String word = S.substring(i+j*size, i+(j+1)*size);
	                SMap.put(word, !SMap.containsKey(word) ? 
	                        1 : SMap.get(word)+1);
	            }
	            if (SMap.equals(LMap)) 
	            	result.add(i);
	        }
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		String S = "barfoothefoobarman";
		String[] L = {"foo", "bar"};
		SubstringWithConcatenationOfAllWords sub = 
				new SubstringWithConcatenationOfAllWords();
		List<Integer> result = sub.findSubstring(S, L);
		System.out.println(result);
		for(int r : result)
			System.out.println(r + "\t");
	}
}
