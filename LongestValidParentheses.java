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
	 * 首先将左括号对应的下标保存在栈中，然后依次判断右括号，遇到一个右括号就将栈中
	 * 对应的一个左括号出栈，如果栈为空，目前最大的长度就是当前下标减去left值与最
	 * 大值的较大者，如果
	 * 不为空，那么当前最大长度就是下标减去栈中的元素个数和目前最大值的较大者。
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
