package com.leetcode;

/**
 * 罗马数字规则：
 * 1、共有7个:I(1)、V(5)、X(10)、L(50)、C(100)、D(500)、M(1000)
 * 2、一个罗马数字最多重复3次
 * 3、右加左减：IV(4)、VI(6)
 * 4、左减的数字有限制，仅限于I、X、C,且放在大数左边的只能用一个
 * 		V和X左边的小数字只能用I；
 * 		L和C左边的小数字只能用X；
 * 		D和M左边的小数字只能用C。
 * 因为一个罗马数字最多重复3次，所以，4,9只能由一个高位减去一个低位获得，而不能通过连续的重复得到，
 * 因此我们可以直接将4,9,40,90等计算出来放到数组里面。然后利用数字不断地减去数组里面的数字得到
 * 对应的罗马数字。
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
