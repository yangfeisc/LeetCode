package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return  [["aa","b"],["a","a","b"]]
 * @author yangfei
 *
 */
public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        if(s == null)
        	return null;
        List<List<String>> result = new ArrayList<List<String>>();
        partitionSolution(s, result, new ArrayList<String>());
        return result;
    }
	
	public void partitionSolution(String s, List<List<String>> res, List<String> subRes) {
		if(s.length() <= 1) {
			if(s.length() != 0)
				subRes.add(s);
			res.add(subRes);
			return;
		} 
		for(int i=1; i<=s.length(); i++) {
			String str = s.substring(0, i);
			List<String> clone = new ArrayList<>();
			clone.addAll(subRes);
			if(palindrome(str)) {
				clone.add(str);
				partitionSolution(s.substring(i), res, clone);
			}
		}
	}
	
	public boolean palindrome(String s) {
		if(s.length() == 1) return true;
		int l = 0, r=s.length()-1;
		while(l <= r) {
			if(s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s = "aabb";
		PalindromePartitioning pp = new PalindromePartitioning();
		List<List<String>> result = pp.partition(s);
		for(int i=0; i<result.size(); i++)
			System.out.println(Arrays.toString(result.get(i).toArray()));
	}
}
