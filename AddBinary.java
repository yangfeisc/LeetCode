package com.leetcode;

/**
 * Given two binary strings, 
 * return their sum (also a binary string).
 * Notes:�������ַ������ܺܳ����޷�ת��Ϊʮ��������
 * ͨ���Ӻ���ǰ��������ַ���ÿһλ������λ���
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
		int carry = 0; //�ж��Ƿ���Ҫ��λ
		if(a.length() < b.length()) {
			String tmp = a;
			a = b; 
			b = tmp;
		}
		int i = a.length() - 1;
		int j = b.length() - 1;
		//�ӵ�λ��ʼ�������a,b��Ӧ�ַ�
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
		//��a��ʣ��λ��ӵ�����У�����Ҫ���ǽ�λ�Ƿ�Ϊ1
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
