package com.leetcode;

public class StringToInteger {
	public int myAtoi(String str) {
        if(str == null) return 0;
        str = str.trim();
        int len = str.length();
        if(len == 0) return 0;
        boolean flag = false;
        long res = 0;
        for(int i=0; i<len; i++) {
            char c = str.charAt(i);
            if(i==0 && c == '-') {
                flag = true;
                continue;
            }
            if(i==0 && c == '+') {
                flag = false;
                continue;
            }
            if(c < '0' || c > '9')
                break;
            res = 10*res + (str.charAt(i)-'0');
            if(flag && res-1 >= Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            } else if(!flag && res >= Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        return flag ? 0-(int)res : (int)res;
    }
	
	public static void main(String[] args) {
		StringToInteger sti = new StringToInteger();
		String str = "  -00134";
		System.out.println(sti.myAtoi(str));
	}
}
