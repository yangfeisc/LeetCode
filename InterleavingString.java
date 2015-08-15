package com.leetcode;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving 
 * of s1 and s2.
 * For example, Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * @author yangfei
 *
 */
public class InterleavingString {
	/**
	 * DP
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
        	return false;
		boolean[][] res = new boolean[s2.length()+1][s1.length()+1];
		res[0][0] = true;
		for(int i=1; i<s1.length()+1; i++) {
			res[0][i] = res[0][i-1] && (s1.charAt(i-1) == s3.charAt(i-1));
		}
		for(int i=1; i<s2.length()+1; i++) {
			res[i][0] = res[i-1][0] && (s2.charAt(i-1)==s3.charAt(i-1));
		}
		for(int i=1; i<s2.length()+1; i++) {
			for(int j=1; j<s1.length()+1; j++) {
				res[i][j] = (res[i][j-1] && s1.charAt(j-1)==s3.charAt(i+j-1))
						|| (res[i-1][j] && s2.charAt(i-1)==s3.charAt(i+j-1));
			}
		}
		return res[s2.length()][s1.length()];
    }
	
	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "";
		String s3 = "a";
		String s4 = "aadbbbaccc";
		InterleavingString is = new InterleavingString();
		System.out.println(is.isInterleave(s1, s2, s3));
		System.out.println(is.isInterleave(s1, s2, s4));
	}
}
