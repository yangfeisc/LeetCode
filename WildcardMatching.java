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
	 * ͨ������s�ַ����������ж�s�ж�Ӧ�ַ��Ƿ���p�ж�Ӧ�ַ���ͬ�������ͬ������������ͬ����false��
	 * 1��p�е�'?'ƥ��s������λ�õ��ַ���
	 * 2��p�е�'*'ƥ��s�����ⳤ�ȵ��Ӵ���ͬʱҲ����ƥ����ַ�����
	 * ������������i��j�ֱ����ڱ���s��p�е�Ԫ�ء�
	 * ������������start��mark�ֱ����ڱ��p�е�'*'λ���Լ�ƥ�䵽p��'*'ʱs�ĵ�ǰλ�á�
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
        		start = j++;  //start���'*'λ�ã�j��ʱΪp��'*'���һ����'*'�ַ���
        		mark = i;     //��¼��ʱs�ı���λ��
        	} else if(start != -1) {
        		j = start + 1; //��ʱjΪp��'*'���һ����'*'�ַ���
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
