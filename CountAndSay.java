package com.leetcode;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * @author yangfei
 *
 */
public class CountAndSay {
	/**
	 * 统计结果中对应的元素的个数，例如"111121" say "411211";
	 * @param n
	 * @return
	 */
	public String countAndSay1(int n) {
        String result = "1";
        for(int i=1; i<n; i++) {
			int count = 0;
			char[] ele = result.toCharArray();
			char cur = ele[0];
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<ele.length; j++) {
				if(ele[j] == cur) {
					count++;
				} else {
					sb.append(count).append(cur);
					count = 1;
					cur = ele[j];
				}
				if(j == ele.length-1) {
					sb.append(count).append(cur);
				}
			}
        	result = sb.toString();
        }
		return result;
    }
	
	/**
	 * 递归实现
	 * @param n
	 * @return
	 */
	public String countAndSay2(int n) {
        if(n <= 0)
            return "";
        if(n == 1)
            return "1";
        String str = countAndSay2(n-1);
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for(int i=0; i<len;) {
            int count = 1;
            char c = str.charAt(i);
            i++;
            while(i<len && str.charAt(i) == c) {
                count++;
                i++;
            }
            sb.append(count).append(c);
        }
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
		CountAndSay cs = new CountAndSay();
		String res1 = cs.countAndSay1(10);
		String res2 = cs.countAndSay2(10);
		System.out.println("res: " + res1 + "\t" + res2);
	}
}
