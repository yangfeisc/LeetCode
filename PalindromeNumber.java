package com.leetcode;

/**
 * 原理，每次取数的最高位和最低位进行比较，如果相同就继续比较，不相同就不是回文字。
 * 首先，判断x有多少位，即循环获得需要循环多少次才能得到最高位
 * 其次，不断获取x的最高位和最低位，判断两者是否相同，相同继续循环，不同则返回false
 * 最后，通过“求10余”得到除最高位的剩余数字，对得到的数字除以10，得到除最低位的数字
 * @author yangfei
 *
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if(x < 0)
        	return false;
        if(x == 0)
        	return true;
        
        int index = 1; 
        while(x/index >= 10) {
        	index *= 10;
        }
        
        while(x > 0) {
        	if(x/index != x%10)
        		return false;
        	x %= index;      //减去数字的最高位    
        	index /= 100;    //每次减去两位数
        	x /= 10;         //减去数字的最低位 
        }
        return true;
    }
	
	public static void main(String[] args) {
		int x = 1221;
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(x));
	}
}
