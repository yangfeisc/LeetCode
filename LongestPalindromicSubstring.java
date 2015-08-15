package com.leetcode;

/**
 * 方法一：将字符串翻转，然后找两个字符串的最大公共子串即为最长回文子串。
 * 方法二：每次找一个中心向两边扩展得到最大子串
 * @author yangfei
 */
public class LongestPalindromicSubstring {
	
//	public String longestPalindrome(String s) {
//		int len = s.length();
//        if(len == 0) 
//        	return "";
//        if(len == 1)
//        	return s;
//        String result = "";
//        String reverse = "";
//        
//        for(int i=len-1; i>=0; i--) { 	//reverse the original string
//        	reverse += s.charAt(i);
//        }
//        System.out.println(reverse);
//        
//        for(int i=0; i<len; i++) {
//        	for(int j=len-1; j>i; j--) {
//        		if(s.contains(reverse.substring(i, j+1))) {
//        			if(result.length() < j+1-i)
//        				result = reverse.substring(i, j+1);
//        		}
//        	}
//        }
//       
//        return result;
//    }
	
	public String longestPalindrome(String s) {
		int len = s.length();
		if (len == 0) {
			return "";
		}
	 
		if (len == 1) {
			return s;
		}
	 
		String longest = s.substring(0, 1);
		for (int i = 0; i < len; i++) {
			// 回文子串长度为奇数，每次只有一个中心
			String tmp = helper(s, i, i);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
	 
			// 回文子串长度为偶数，每次有两个中心
			tmp = helper(s, i, i + 1);
			if (tmp.length() > longest.length()) {
				longest = tmp;
			}
		}
	 
		return longest;
	}
	 
	public String helper(String s, int begin, int end) {
		while (begin >= 0 && end <= s.length() - 1 
				&& s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		return s.substring(begin + 1, end);
	}
	
	public static void main(String[] args) {
		String s = "tfekavrnnptlawqponffseumswvdtjhrndkkjppgiajjhklqpskuubeyofqwubiiduoylurzlorvnfcibxcjjzvlzfvsvwknjkzwthxxrowidmyudbtquktmyunoltklkdvzplxnpkoiikfijgulbxfxhaxnldvwmzpgaiumnvpdirlrutsqenwtihptnhghobrmmzcsrhqgdgzrvvitzgsolsxjxfeencvpnltxeetmtzlwnhlvgtbhkicivylfjhhfqteyxewmnewhmsnfdyneqoywgsgptwdlzbraksgajciebdchindegdfmayvfkwwkkfyxqjcv";
		LongestPalindromicSubstring lps = 
				new LongestPalindromicSubstring();
		System.out.println(lps.longestPalindrome(s));
	}
}
