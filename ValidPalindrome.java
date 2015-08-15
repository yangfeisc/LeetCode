package com.leetcode;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example, 
 * "A man, a plan, a canal: Panama" is a palindrome(回文字符串).
 * "race a car" is not a palindrome.
 * 
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * @author yangfei
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome1(String s) {
		s = s.toLowerCase();
		s = s.replaceAll("\\W", "");  //"\\W"匹配任意非字母以及非数字  \\w匹配任意的字母及数字
		for(int i=0; i<s.length()/2; i++) {
			if(s.charAt(i) != s.charAt(s.length()-1-i))
				return false;
		}
		return true;
	}
	public boolean isPalindrome(String s) {
        if(s == null || s.length() == 1)
        	return true;
        int left = 0;
        int right = s.length() - 1;
        s = s.toLowerCase();
        boolean lf, rf;
        char lc = 0, rc = 0;
        while(left < right) {
        	lf = false;
        	rf = false;
        	while(!lf && (left <= right)) {
        		lc = s.charAt(left);
        		if((lc>='a' && lc<='z') || (lc>='0' && lc<='9'))
        			lf = true;
        		else 
        			left++;
        	}
        	while(!rf && (right >= left)) {
        		rc = s.charAt(right);
        		if((rc>='a' && rc<='z') || (rc>='0' && rc<='9'))
        			rf = true;
        		else 
        			right--;
        	}
        	System.out.println(lc + "\t" + rc);
        	if(lf && rf && lc != rc)
        		return false;
        	
        	left++;
        	right--;
        }
        return true;
    }
	
	public static void main(String[] args) {
		ValidPalindrome vp =new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		String s1 = "race a car";
		String s2 = "a.";
		System.out.println(vp.isPalindrome1(s));
		System.out.println(vp.isPalindrome1(s1));
		System.out.println(vp.isPalindrome1(s2));
	}
}

