package com.leetcode;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the 
 * bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 * @author yangfei
 *
 */
public class BitwiseANDOfNumbersRange {
	public int rangeBitwiseAnd(int m, int n) {
        if(m > n || m == 0)
            return 0;
        int offset = 0;
        while(m != 0 && n != 0) {
            if(m == n)
                return m << offset;
            m >>= 1;
            n >>= 1;
            offset++;
        }
        return 0;
    }
}
