package com.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		
		boolean[] index = new boolean[256];   //保存每个字符出现的位置 
		int maxLength = 0;
		int start = 0, end = 0;
		for(; end<s.length(); end++) {
			if(index[s.charAt(end)]) {  //当前字符已在前面扫描中存在
				int len = end - start;
				maxLength = maxLength>len ? maxLength:len;
				while (s.charAt(start) != s.charAt(end)) { //字符在中间重复，需要移动到重复的下一个位置
					index[s.charAt(start)] = false;
					start++;
				}
				start++;
			} else {
				index[s.charAt(end)] = true;
			}
		}
		maxLength = maxLength>(end-start) ? maxLength:(end-start);
		
		return maxLength;
    }
	
	public static void main(String[] args) {
		String str = "asaaaaaa";
		LongestSubstringWithoutRepeatingCharacters lswrc = 
				new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(lswrc.lengthOfLongestSubstring(str));
	}
}
