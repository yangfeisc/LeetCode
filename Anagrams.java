package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of strings, return all groups of strings that are anagrams(��λ��).
 * Note: All inputs will be in lower-case.
 * @author yangfei
 *
 */
public class Anagrams {
	
	/**
	 * ���ȶ����е��ַ�����������Ȼ���ж������ַ����ǲ��Ǳ�λ�ʡ�
	 * @param strs
	 * @return
	 */
	public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<>();
        if(strs.length <= 0)
        	return result;
        String[] temp = strs.clone();
        for(int i=0; i<temp.length; i++) {
        	char[] t = temp[i].toCharArray();
        	Arrays.sort(t);
        	StringBuilder sb = new StringBuilder();
        	for(char c : t)
        		sb.append(c);
        	temp[i] = sb.toString();
        }
        for(int i=0; i<temp.length; i++) {
        	boolean flag = false;
        	for(int j=i+1; j<temp.length; j++) {
        		if(temp[j].equals(temp[i])) {
        			result.add(strs[j]);
        			flag = true;
        		}
        	}
        	if(flag)
        		result.add(strs[i]);
        }
        
        return result;
	}
	
	public static void main(String[] args) {
		String[] strs = {"abc", "acb", "bca"};
		Anagrams an = new Anagrams();
		List<String> ll = an.anagrams(strs);
		for(String s : ll)
			System.out.println(s);
	}
}
