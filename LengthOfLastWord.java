package com.leetcode;

/**
 * Given a string s consists of upper/lower-case alphabets 
 * and empty space characters ' ', return the length of last 
 * word in the string. If the last word does not exist, return 0. 
 * Note: A word is defined as a character sequence 
 * consists of non-space characters only. 
 * For example,
 * Given s = "Hello World", return 5.
 * @author yangfei
 *
 */
public class LengthOfLastWord {
	public int lengthOfLastWord(String s) {
        if(s.trim().isEmpty() || s.length() == 0)
        	return 0;
        String[] str = s.split("\\s+");
        int index = str.length - 1;
        return str[index].length();
    }
	
	public static void main(String[] args) {
		String s = "  ";
		LengthOfLastWord low = new LengthOfLastWord();
		int result = low.lengthOfLastWord(s);
		System.out.println(result);
	}
}
