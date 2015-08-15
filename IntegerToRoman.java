package com.leetcode;

/**
 * �������ֹ���
 * 1������7��:I(1)��V(5)��X(10)��L(50)��C(100)��D(500)��M(1000)
 * 2��һ��������������ظ�3��
 * 3���Ҽ������IV(4)��VI(6)
 * 4����������������ƣ�������I��X��C,�ҷ��ڴ�����ߵ�ֻ����һ��
 * 		V��X��ߵ�С����ֻ����I��
 * 		L��C��ߵ�С����ֻ����X��
 * 		D��M��ߵ�С����ֻ����C��
 * ��Ϊһ��������������ظ�3�Σ����ԣ�4,9ֻ����һ����λ��ȥһ����λ��ã�������ͨ���������ظ��õ���
 * ������ǿ���ֱ�ӽ�4,9,40,90�ȼ�������ŵ��������档Ȼ���������ֲ��ϵؼ�ȥ������������ֵõ�
 * ��Ӧ���������֡�
 * @author yangfei
 *
 */
public class IntegerToRoman {
	public String intToRoman(int num) {
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", 
        		"C", "CD", "D", "CM", "M"};
        int[] inte = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        if(num >= 4000 || num <= 0)
            return null;
        StringBuilder res = new StringBuilder();
        for(int i=inte.length-1; i>=0;) {
            if(num >= inte[i]) {
                res.append(roman[i]);
                num -= inte[i];
            } else 
                i--;
        }
        return res.toString();
    }
	
	public static void main(String[] args) {
		int num = 1;
		IntegerToRoman itr = new IntegerToRoman();
		String result = itr.intToRoman(num);
		System.out.println(result);
	}
}
