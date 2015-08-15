package com.leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		
		boolean[] index = new boolean[256];   //����ÿ���ַ����ֵ�λ�� 
		int maxLength = 0;
		int start = 0, end = 0;
		for(; end<s.length(); end++) {
			if(index[s.charAt(end)]) {  //��ǰ�ַ�����ǰ��ɨ���д���
				int len = end - start;
				maxLength = maxLength>len ? maxLength:len;
				while (s.charAt(start) != s.charAt(end)) { //�ַ����м��ظ�����Ҫ�ƶ����ظ�����һ��λ��
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
