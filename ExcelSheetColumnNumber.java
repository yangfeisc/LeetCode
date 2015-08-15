package com.leetcode;

/**
 * Given a column title as appear in an Excel sheet, 
 * return its corresponding column number.
 * For example
 * A -> 1, B -> 2, ... Z -> 26
 * AA -> 27, AB -> 28, ...
 * @author yangfei
 *
 */
public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if(s.length() == 0)
			return 0;
		int result = 0;
		s = s.toUpperCase();
        for(int i=0; i<s.length(); i++) {
        	result = result*26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		String s = "az";
		ExcelSheetColumnNumber esc = new ExcelSheetColumnNumber();
		int result = esc.titleToNumber(s);
		System.out.println("result: " + result);
	}
}
