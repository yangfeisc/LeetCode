package com.leetcode;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * @author yangfei
 *
 */
public class PalindromePartitioningII {
	public int minCut(String s) {
		int len = s.length();
		if(len < 2) 
			return 0;
		int[][] isPalindrome = new int[len][len]; //记录回文串
		int[] cut = new int[len+1];  //记录不同位置对应的最小切分数
		for(int i=len-1; i>=0; i--) {
			cut[i] = len;
			for(int j=i; j<s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					if(j-i<2 || isPalindrome[i+1][j-1] == 1) {
						isPalindrome[i][j] = 1;  //i到j为回文串
						cut[i] = Math.min(cut[i], cut[j+1]+1);
	                }
				}
			}
		}
		return cut[0] - 1;
	}
	
	public static void main(String[] args) {
		String s = "abcb";
		PalindromePartitioningII pp = new PalindromePartitioningII();
		System.out.println(pp.minCut(s));
	}
}
