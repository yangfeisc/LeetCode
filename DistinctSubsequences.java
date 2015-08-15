package com.leetcode;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions 
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example: S = "rabbbit", T = "rabbit" Return 3.
 * @author yangfei
 *
 */
public class DistinctSubsequences {
	public int numDistinct(String s, String t) {
        if(s.length() == 0 || t.length() == 0 
        		|| s.length() < t.length())
        	return 0;
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0; i<s.length()+1; i++) {
        	dp[i][0] = 1;
        }
        for(int i=1; i<s.length()+1; i++) {
        	for(int j=1; j<t.length()+1; j++) {
       			dp[i][j] = dp[i-1][j];
       			if(s.charAt(i-1) == t.charAt(j-1))
        			dp[i][j] += dp[i-1][j-1];
        	}
        }
        return dp[s.length()][t.length()];
    }
	
	public static void main(String[] args) {
		String s = "rabbbit";
		String t = "rabbit";
		DistinctSubsequences ds = new DistinctSubsequences();
		System.out.println(ds.numDistinct(s, t));
	}
}
