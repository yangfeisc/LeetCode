package com.leetcode;

import java.util.Scanner;

public class ScambleString {
	
	/**
	 * 这个函数使用了递归的思想，通过不断地对比较两个子字符串的情况进行比较
	 * @param s1
	 * @param s2
	 * @return
	 */
//	public boolean isScramble(String s1, String s2) {
//		int len1 = s1.length();
//		int len2 = s2.length();
//		if(len1 != len2) {
//			return false;
//		} 
//		if(len1 == 0) {
//			return true;
//		}
//		
//		char[] c1 = s1.toCharArray();
//		char[] c2 = s2.toCharArray();
//		if(len1==1) {
//			return c1[0] == c2[0];
//		}
//		
//		Arrays.sort(c1);
//		Arrays.sort(c2);
//		for(int i=0; i<c1.length; i++) {
//			if(c1[i] != c2[i]) {
//				return false;
//			}
//		}
//		
//		boolean result = false;
//		for(int i=1; i<len1 && !result; i++) {
//			String str1 = s1.substring(0, i);
//			String str2 = s1.substring(i);
//			String str3 = s2.substring(0, i);
//			String str4 = s2.substring(i);
//
//			result = isScramble(str1, str3) && isScramble(str2, str4);
//				
//			if(!result) {
//				String str5 = s2.substring(0, len2-i);
//				String str6 = s2.substring(len2-i);
//				result = isScramble(str1, str6) && isScramble(str2, str5);
//			}
//		}
//		return result;
//	}
	
	/**
	 * 这个函数使用动态规划思想实现判断两个字符串是不是Scramble，在这个过程中建一个3维数组result[k][i][j]
	 * 表示字符串s1从i开始到(i+k)是否与s2从j到(j+k)是Scramble。
	 * @param s1
	 * @param s2
	 * @return
	 */
	public boolean isScramble(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		if(len1 != len2) {
			return false;
		} 
		if(len1 == 0) {
			return true;
		}
		boolean[][][] result = new boolean[len1][len1][len1];
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		for(int i=0; i<len1; i++) {
			for(int j=0; j<len1; j++) {
				boolean r = (c1[i]==c2[j]);
				result[0][i][j] = r;
			}
		}
		
		for(int k=2; k<=len1; k++) {
			for(int i=len1-k; i>=0; i--) {
				for(int j=len1-k; j>=0; j--) {
					boolean r = false;
					for(int m=1; m<k && !r; m++) {
						r = (result[m-1][i][j] && result[k-m-1][i+m][j+m])
								|| (result[m-1][i][j+k-m] && result[k-m-1][i+m][j]);
					}
					result[k-1][i][j] = r;
				}
			}
		}
		return result[len1-1][0][0];
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner ss = new Scanner(System.in);
		String line = ss.nextLine();
		String[] str = line.split("\\s+");
		if(str.length != 2) {
			System.out.println("You should input two strings");
		} else {
			ScambleString solution = new ScambleString();
			String s1 = str[0];
			String s2 = str[1];
			boolean isScramble = solution.isScramble(s1, s2);
			if(isScramble) {
				System.out.println(s1 + " and " + s2 + " are scramble strings");
			} else {
				System.out.println(s1 + " and " + s2 + " are not scramble strings");
			}
		}
		
	}
}
