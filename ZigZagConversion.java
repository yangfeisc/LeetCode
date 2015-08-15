package com.leetcode;

public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if(nRows <= 0)
			return null;
		if(nRows == 1)
			return s;
		
		int len = s.length();
		
		String result = "";
		for(int i=0; i<nRows; i++) {
			for(int j=i; j<len;) {
				result += s.charAt(j);
				j += 2*nRows - 2;
				if(i > 0 && i < nRows-1) {
					if(j-2*i < len)
						result += s.charAt(j-2*i);
				}
			}
		}
		return result;
    }
	
	public static void main(String[] args) {
		String s = "abcdefghijklmn";
		ZigZagConversion zzc = new ZigZagConversion();
		System.out.println(zzc.convert(s, 3));
	}
}
