package com.leetcode;

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
        if(n <= 26)
        	return (char)(n + 'A' - 1) + "";
        String result = "";
        while(n > 0) {
        	int tail = (n-1) % 26;
        	result = (char)(tail + 'A') + result;
        	n = (n-1) / 26;  //用于计算下一个字符
        }
        return result;
    }
	
	public static void main(String[] args) {
		ExcelSheetColumnTitle es = new ExcelSheetColumnTitle();
		int num = 52;
		String result = es.convertToTitle(num);
		System.out.println(result);
	}
}
