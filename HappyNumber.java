package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy". A happy number 
 * is a number defined by the following process: Starting with any positive 
 * integer, replace the number by the sum of the squares of its digits, and 
 * repeat the process until the number equals 1 (where it will stay), or it 
 * loops endlessly in a cycle which does not include 1. Those numbers for which 
 * this process ends in 1 are happy numbers. 
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * @author yangfei
 *
 */
public class HappyNumber {
	public boolean isHappy(int n) {
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        while(true) {
        	set.add(n);
        	while(n > 0) {
        		int num = n%10;
        		sum += num*num;
        		n = n / 10;
        	}
        	if(sum == 1)
        		return true;
        	else if(set.contains(sum))
        		return false;
        	n = sum;
        	sum = 0;
        }
    }
	
	public static void main(String[] args) {
		HappyNumber hn = new HappyNumber();
		System.out.println(hn.isHappy(19));
	}
}
