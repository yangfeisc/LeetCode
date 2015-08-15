package com.leetcode;

/**
 * Given two binary strings, 
 * return their sum (also a binary string).
 * Notes:二进制字符串可能很长，无法转换为十进制整数
 * 通过从后向前逐个遍历字符串每一位，将两位相加
 * @author yangfei
 *
 */
public class AddBinary {
	public String addBinary(String a, String b) {
        if(a == null) 
        	return b;
        if(b == null)
        	return a;
		String result = "";
		int sum;
		int carry = 0; //判断是否需要进位
		if(a.length() < b.length()) {
			String tmp = a;
			a = b; 
			b = tmp;
		}
		int i = a.length() - 1;
		int j = b.length() - 1;
		//从低位开始依次相加a,b对应字符
		for(; i>=0 && j>=0; i--, j--) {
			sum = (a.charAt(i)-'0') + (b.charAt(j)-'0') + carry;
			if(sum >= 2) {
				carry = 1;
				result = (sum - 2) + result; 
			} else {
				carry = 0;
				result = sum + result;
			}
        }
		//将a的剩余位添加到结果中，但是要考虑进位是否为1
		while(i >= 0) {
			if(carry == 0) {
				result = a.substring(0, i+1) + result;
				return result;
			} else {
				sum = (a.charAt(i)-'0') + carry;
				if(sum == 2) {
					carry = 1;
					result = "0" + result;
				} else {
					carry = 0;
					result = "1" + result;
				}
			}
			i--;
		}
		if(carry == 1)
			return carry + result;
		return result;
    }
	
	public static void main(String[] args) {
		String a = "100";
		String b = "110010";
		AddBinary ab = new AddBinary();
		String s = ab.addBinary(a, b);
		System.out.println(s);
	}
}
