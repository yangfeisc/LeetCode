package com.leetcode;

/**
 * 寻找字符串数组中字符串的最长公共前缀
 * 采用的算法：遍历整个数组，每次比较相邻两个字符串s[i]和s[i+1]的公共前缀prefix，然后将s[i+1]
 * 换成公共前缀prefix，继续寻找s[i+1]到s[n]的最大公共前缀
 * @author yangfei
 *
 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
        	return "";
        if(strs.length == 1)
        	return strs[0];
        int len = strs.length;
        return longestPrefix(strs, 0, len-1);
    }
	public String longestPrefix(String[] strs, int begin, int end) {
		if(begin > end)
			return "";
		if(begin == end)
			return strs[begin];
		String prefix = "";
		int len1 = strs[begin].length();
		int len2 = strs[begin+1].length();
		int index = len1 < len2 ? len1:len2;
		for(int i=0; i<index; i++) {
			char one = strs[begin].charAt(i);
			char two = strs[begin+1].charAt(i);
			if(one == two)
				prefix += one;
			else 
				break;
		}
		if(prefix == "")
			return "";
		
		strs[begin+1] = prefix;
		return longestPrefix(strs, begin+1, end);
	}
	
	/**
	 * 直接判断字符串的相同位置元素是否相同，如果任意两个字符串的不同就返回结果。
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0)
            return "";
        int minLen = strs[0].length();
        for(int i=1; i<strs.length; i++) {
            int len = strs[i].length();
            minLen = minLen<len ? minLen : len;
        }
        StringBuilder sb = new StringBuilder(minLen);
        for(int i=0; i<minLen; i++) {
            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(strs[j].charAt(i) != c)
                    return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String[] str = {"abcde", "abcef", "abcd"};
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		System.out.println(lcp.longestCommonPrefix(str));
	}
}
