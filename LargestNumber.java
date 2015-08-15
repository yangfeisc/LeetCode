package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange 
 * them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed 
 * number is 9534330.
 * Note: The result may be very large, so you need to return 
 * a string instead of an integer.
 * @author yangfei
 *
 */
public class LargestNumber {
	public String largestNumber(int[] num) {
        String[] str = new String[num.length];
        int i;
        for(i=0; i<num.length; i++) {
        	str[i] = String.valueOf(num[i]);
        }
        Arrays.sort(str, new Comp());
        StringBuilder sb = new StringBuilder();
        for(i=0; i<str.length; i++) {
        	sb.append(str[i]);
        }
        for(i=0; i<sb.length(); i++) {
        	if(sb.charAt(i) != '0') {
        		break;
        	}
        }
        if(i > sb.length()-1)
        	return "0";
        
        return sb.substring(i);
    }
	
	public static void main(String[] args) {
		int[] num = {0,0};
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(num));
	}
}

class Comp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		String ab = o1 + o2;
		String ba = o2 + o1;
		return ba.compareTo(ab);
	}
	
}
