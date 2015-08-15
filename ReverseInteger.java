package com.leetcode;

public class ReverseInteger {
    
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE)
            return 0;
        boolean flag = false;
        if(x < 0) {
            flag = true;
            x = -x;
        }
        long res = 0;
        while(x > 0) {
            res = 10*res + x%10;
            if(!flag && res>Integer.MAX_VALUE
                || flag && res-1 > Integer.MAX_VALUE)
                return 0;
            x = x / 10;
        }
        return flag ? (int) (-res) : (int)res;
    }
    
    public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
    	int number = -2147483647;
		int reverse = ri.reverse(number);
		System.out.println(reverse);
	}
}
