package com.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses 
 * substring.For "(()", the longest valid parentheses substring is 
 * "()", which has length = 2. Another example is ")()())", where 
 * the longest valid parentheses substring is "()()", which has 
 * length = 4.
 * @author yangfei
 *
 */
public class LongestValidParentheses {
	/**
	 * ���Ƚ������Ŷ�Ӧ���±걣����ջ�У�Ȼ�������ж������ţ�����һ�������žͽ�ջ��
	 * ��Ӧ��һ�������ų�ջ�����ջΪ�գ�Ŀǰ���ĳ��Ⱦ��ǵ�ǰ�±��ȥleftֵ����
	 * ��ֵ�Ľϴ��ߣ����
	 * ��Ϊ�գ���ô��ǰ��󳤶Ⱦ����±��ȥջ�е�Ԫ�ظ�����Ŀǰ���ֵ�Ľϴ��ߡ�
	 * @param s
	 * @return
	 */
	public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int left = -1;
        int max = 0;
        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == '(') {
        		stack.push(i);
        	} else {
        		if(stack.isEmpty())
        			left = i;
        		else {
        			stack.pop();
        			if(stack.isEmpty())
        				max = max>(i-left) ? max : (i-left);
        			else
        				max = max>(i-stack.peek()) ? max : (i-stack.peek());
        		}
        	}
        }
        return max;
    }
	
	public static void main(String[] args) {
		String s = "(()";
		LongestValidParentheses lv = new LongestValidParentheses();
		System.out.println(lv.longestValidParentheses(s));
	}
}
