package com.leetcode;

public class DivideTwoIntegers {
	
	/**
	 * ÿ��ʹ�ñ�������ȥ������ֱ��������Ϊ0����С�ڳ�����
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
	 * ������������λ���㣬���Ƚ������ͱ�����ת��long�ͣ�����߽����Ȼ���ж��������Ƿ�С��0��
	 * ���С��0����ת������������һ������Ϊ32�����飬��¼һ��������λ�����Ƚ�������Ӧ���������ƣ�
	 * ��¼����ʱÿλ��0����1��Ȼ��ʹ�ñ����������ƺ�ĸ����������жϣ�������������ڶ�Ӧ��λ����
	 * ����������ȥ�������Ȼ������жϣ�ʱ�临�Ӷ�ΪO(logN)��
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
