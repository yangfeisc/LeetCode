package com.leetcode;

/**
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * @author yangfei
 *
 */
public class WildcardMatching {
	/**
	 * 通过遍历s字符串，依次判断s中对应字符是否与p中对应字符相同，如果相同继续遍历，不同返回false。
	 * 1、p中的'?'匹配s中任意位置的字符；
	 * 2、p中的'*'匹配s中任意长度的子串，同时也可以匹配空字符串。
	 * 定义两个变量i和j分别用于遍历s和p中的元素。
	 * 定义两个变量start和mark分别用于标记p中的'*'位置以及匹配到p中'*'时s的当前位置。
	 * @param s
	 * @param p
	 * @return
	 */
	public boolean isMatch(String s, String p) {
		int i = 0, j = 0; 
        int start = -1, mark = -1;
        while(i < s.length()) {
        	if(j<p.length() && (s.charAt(i) == p.charAt(j) || 
        			p.charAt(j) == '?')) {
        		++j;
        		++i;
        	} else if(j<p.length() && p.charAt(j) == '*') {
        		start = j++;  //start标记'*'位置，j此时为p中'*'后第一个非'*'字符。
        		mark = i;     //记录此时s的遍历位置
        	} else if(start != -1) {
        		j = start + 1; //此时j为p中'*'后第一个非'*'字符。
        		i = ++mark;
        	} else 
        		return false;
        }
        
        while(j < p.length()) {
        	if(p.charAt(j++) != '*')
        		return false;
        }
        return true;
	}
	
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		System.out.println(wm.isMatch("aa", "a"));
		System.out.println(wm.isMatch("", "*"));
		System.out.println(wm.isMatch("abcd", "?*"));
		System.out.println(wm.isMatch("abcd", "abc?"));
		System.out.println(wm.isMatch("abcd", "?abc"));
		System.out.println(wm.isMatch("abcd", "a?bc*"));
		System.out.println(wm.isMatch("abcd", "abbc"));
	}
}
