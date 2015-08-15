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
	 * 由于java1.6中没有unsigned int类型，所以该程序对于1的输出结果是错误的，因为
	 * 如果输入为1，则反转后结果为10000000000000000000000000000000，按照有 符号来看这个数是-2147483648
	 * 程序中的toUnsignedString()函数只有在java1.8中才有
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
