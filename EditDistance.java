package com.leetcode;

/**
 * Given two words word1 and word2, find the minimum number of steps required to 
 * convert word1 to word2. (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * @author yangfei
 *
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        if(m == 0)
        	return n;
        if(n == 0)
        	return m;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<=n; i++) 
        	dp[0][i] = i;
        for(int i=0; i<=m; i++) 
        	dp[i][0] = i;
        for(int i=1; i<=m; i++) {
        	char c1 = word1.charAt(i-1);
        	for(int j=1; j<=n; j++) {
        		char c2 = word2.charAt(j-1);
        		if(c1 == c2) 
        			dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i-1][j-1], dp[i][j-1]+1));
        		else 
        			dp[i][j] = Math.min(dp[i-1][j]+1, Math.min(dp[i-1][j-1]+1, dp[i][j-1]+1));
        	}
        }
        return dp[m][n];
    }
	
	public static void main(String[] args) {
		String word1 = "a";
		String word2 = "alrogithm";
		EditDistance ed = new EditDistance();
		System.out.println(ed.minDistance(word1, word2));
	}
}
