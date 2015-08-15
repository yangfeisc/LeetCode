package com.leetcode;

/**
 * Validate if a given string is numeric.Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 * @author yangfei
 *
 */
public class ValidNumber {
	public boolean isNumber(String s) {
		s = s.trim();
        if(s.length() == 0 || s.equals(" "))
        	return false;
        if(s.length() == 1) {
        	if(s.charAt(0) >= '0' && s.charAt(0) <= '9')
        		return true;
        	return false;
        }
        int sign = 0;  //+/-个数,一个数字最多有两个符号。
        int dot = 0; //点的个数，只能有一个点；
        int eChar = 0;  //e或者E的个数，只能有一个；
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if((c == '+' || c == '-') && sign < 2) {
        		sign++;
        		if(i == 0) {
        			if(s.charAt(i+1) != '.' 
        					&& s.charAt(i+1)<'0' || s.charAt(i+1)>'9')
        				return false;
        		} else if(i>0 && i<s.length()-1){
        			if(s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E')
        				return false;
        		} else 
        			return false;
        	} else if(c == '.' && dot < 1 && eChar == 0) {
        		dot++;
        		char t;
        		if(i == 0) {
        			t = s.charAt(i+1);
        			if(t < '0' || t > '9')
        				return false;
        		} else if(i > 0 && i < s.length()-1) {
        			t = s.charAt(i-1);
        			if(t != '+' && t != '-' && (t < '0' || t > '9')) {
        				return false;
        			}
        			t = s.charAt(i+1);
        			if((t != 'e' && t != 'E') && (t < '0' || t > '9'))
        				return false;
        		} else {
        			t = s.charAt(i-1);
        			if(t < '0' || t > '9')
        				return false;
        		}
        	} else if((c == 'e' || c == 'E') && eChar < 1) {
        		eChar++;
        		if(i == 0 || i == s.length() - 1) {
        			return false;
        		} else {
        			char t = s.charAt(i+1);
        			if(t != '+' && t != '-' && (t < '0' || t > '9'))
        				return false;
        			t = s.charAt(i-1);
        			if(t != '.' && (t < '0' || t > '9'))
        				return false;
        		}
        	} else if(c < '0' || c > '9') {
        		return false;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		String s1 = " -.";
		String s2 = " .1. ";
		String s3 = " +.10 ";
		String s4 = "10E3";
		String s5 = "+-3";
		String s6 = ".e2";
		String s7 = "1 3";
		String s8 = "abc";
		String s9 = "005047e+";
		String s10 = "9e";
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber(s1));
		System.out.println(vn.isNumber(s2));
		System.out.println(vn.isNumber(s3));
		System.out.println(vn.isNumber(s4));
		System.out.println(vn.isNumber(s5));
		System.out.println(vn.isNumber(s6));
		System.out.println(vn.isNumber(s7));
		System.out.println(vn.isNumber(s8));
		System.out.println(vn.isNumber(s9));
		System.out.println(vn.isNumber(s10));
	}
}
