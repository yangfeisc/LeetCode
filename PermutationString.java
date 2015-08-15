package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * For a String, output all the permutations.
 * For example: str = "hat", output: "aht", "ath", "hat", "hta", "tah", "tha"
 * @author yangfei
 *
 */
public class PermutationString {
	public List<String> getPermutation(String s) {
		List<String> result = new ArrayList<String>();
		if(s.isEmpty())
			return result;
		if(s.length() == 1) {
			result.add(s);
			return result;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<s.length(); i++)
			sb.append(s.charAt(i));
		getAllPermutation(sb, result, "");
		Collections.sort(result);
		return result;
	}
	
	public void getAllPermutation(StringBuilder sb, List<String> result, String tmp) {
		if(sb.length() == 0) {
			result.add(tmp);
			return;
		}
		for(int i=0; i<sb.length(); i++) {
			char c = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(0));
			sb.setCharAt(0, c);
			tmp += c;
			sb.deleteCharAt(0);
			getAllPermutation(sb, result, tmp);
			tmp = tmp.substring(0, tmp.length()-1);
			sb.insert(0, c);
			char d = sb.charAt(i);
			sb.setCharAt(i, sb.charAt(0));
			sb.setCharAt(0, d);
		}
	}
	
	public static void main(String[] args) { 
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		PermutationString main = new PermutationString();
		List<String> result = main.getPermutation(str);
		for(String s : result) 
			System.out.println(s);
	}
}
