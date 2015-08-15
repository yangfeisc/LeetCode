package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all 
 * the characters in T in complexity O(n).
 * For example, S = "ADOBECODEBANC" T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy 
 * string "".
 * If there are multiple such windows, you are guaranteed that there will always be 
 * only one unique minimum window in S.
 * @author yangfei
 *
 */
public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
        if(S.length() == 0 || S == " " || T.length() == 0
        		|| S.length() < T.length())
        	return "";
        Map<Character, Integer> tMap = new HashMap<>();
        //将T中元素加入Map中，key表示对应的元素，value表示元素出现个数
        for(int i=0; i<T.length(); i++) {
        	char c = T.charAt(i);
        	if(tMap.containsKey(c))
        		tMap.put(c, tMap.get(c)+1);
        	else 
        		tMap.put(c, 1);
        }
        int eleCount = 0;
        int begin = 0, winLeft = 0;
        int minLen = Integer.MAX_VALUE;
        for(int i=0; i<S.length(); i++) {
        	char c = S.charAt(i);
        	if(tMap.containsKey(c)) {
        		tMap.put(c, tMap.get(c)-1);
        		if(tMap.get(c) >= 0) {
        			eleCount++;
        		}
        		while(eleCount == T.length()) {
        			if(i-winLeft+1 < minLen) {
        				minLen = i - winLeft + 1;
        				begin = winLeft;
        			}
        			c = S.charAt(winLeft);
        			if(tMap.containsKey(c)) {
        				tMap.put(c, tMap.get(c) + 1);
        				if(tMap.get(c) > 0)
        					eleCount--;
        			}
        			winLeft++;
        		}
        	}
        }
        return minLen>S.length() ? "" : S.substring(begin, begin+minLen); 
    }
	
	public static void main(String[] args) {
		String S = "bdab";
		String T = "ab";
		MinimumWindowSubstring ms = new MinimumWindowSubstring();
		System.out.println(ms.minWindow(S, T));
	}
}
