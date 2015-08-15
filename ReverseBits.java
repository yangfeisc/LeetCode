package com.leetcode;

/**
 * Reverse bits of a given 32 bits unsigned integer. For example, given input
 * 43261596 (represented in binary as 00000010100101000001111010011100), return
 * 964176192 (represented in binary as 00111001011110000010100101000000). Follow
 * up:If this function is called many times, how would you optimize it?
 * 
 * @author yangfei
 * 
 */
public class ReverseBits {
	// you need treat n as an unsigned value
	/**
	 * ����java1.6��û��unsigned int���ͣ����Ըó������1���������Ǵ���ģ���Ϊ
	 * �������Ϊ1����ת����Ϊ10000000000000000000000000000000�������� ���������������-2147483648
	 * �����е�toUnsignedString()����ֻ����java1.8�в���
	 * @param n
	 * @return
	 */
	public int reverseBits(int n) {
//		String str = Integer.toUnsignedString(n, 2);
		StringBuilder bit = new StringBuilder();
		int count = 0;
		while (n > 0) {
			bit.append((byte) (n & 1));
			n = n >>> 1;
			count++;
		}
		while ((count++) < 32)
			bit.append("0");
		return (int) Long.parseLong(bit.toString(), 2);
//		return (int) Integer.parseUnsignedInt(bit.toString(), 2);
	}
	

	public static void main(String[] args) {
		int n = 1;
		ReverseBits rb = new ReverseBits();
		int result = rb.reverseBits(n);
		System.out.println("\n" + result);
	}
}
