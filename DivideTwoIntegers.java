package com.leetcode;

public class DivideTwoIntegers {
	
	/**
	 * 每次使用被除数减去除数，直到被除数为0或者小于除数。
	 * @param dividend
	 * @param divisor
	 * @return
	 */
//	public int divide(int dividend, int divisor) {
//		if(divisor == 0)
//			return Integer.MAX_VALUE;
//		int result = 0;
//		boolean negative = false;
//		if(dividend < 0 && divisor < 0) {
//			dividend = 0 - dividend;
//			divisor = 0 - divisor;
//		}
//		if(dividend < 0 && divisor > 0) {
//			negative = true;
//			dividend = 0 - dividend;
//		}
//		if(dividend > 0 && divisor < 0) {
//			negative = true;
//			divisor = 0 - divisor;
//		}
//		while(dividend > 0 && dividend > divisor) {
//			dividend -= divisor;
//			result++;
//		}
//		if(negative)
//			return 0 - result;
//		return result;
//	}
	
	/**
	 * 方法二：利用位运算，首先将除数和被除数转成long型，避免边界出错，然后判断两个数是否小于0，
	 * 如果小于0，则转成正数。利用一个长度为32的数组，记录一个整数的位，首先将除数对应的依次左移，
	 * 记录左移时每位是0还是1，然后使用被除数与左移后的各个数进行判断，如果被除数大于对应的位，则
	 * 将被除数减去这个数，然后继续判断，时间复杂度为O(logN)。
	 * @param dividend
	 * @param divisor
	 * @return
	 */
	public int divide(int dividend, int divisor) {
        if (dividend == 0 || divisor == 1)
            return dividend;
        long divid = dividend;
        long divis = divisor;
 
        boolean neg = false;
        long result = 0;
 
        if (dividend < 0) {
            neg = !neg;
           	divid = -divid;
        }
        if (divisor < 0) {
            neg = !neg;
           	divis = -divis;
        }
 
        long[] multi = new long[32];
 
        for (int i = 0; i < 32; i++)
            multi[i] = divis << i;
 
        for (int i = 31; i >= 0; i--) {
        	if(divid == 0)
        		break;
            if (divid >= multi[i]) {
                result += 1 << i;
                divid -= multi[i];
            }
        }
        if(result == Integer.MIN_VALUE)
        	result = Integer.MAX_VALUE;
        return (int) ((neg ? -1 : 1) * result);
    }
	
	public static void main(String[] args) {
		int dividend = -2147483648;
		int divisor = 1;
		DivideTwoIntegers dti = new DivideTwoIntegers();
		int result = dti.divide(dividend, divisor);
		System.out.println("result: " + result);
	}
}
