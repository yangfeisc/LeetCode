package com.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid. The brackets must close in the correct 
 * order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * @author yangfei
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<len; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if(stack.isEmpty()) 
                return false;
            else {
                char t = stack.peek();
                if((c==')' && t!='(') || (c==']' && t!='[')
                    || (c=='}' && t!='{'))
                    return false;
                else 
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		String s = "({[]})";
		ValidParentheses vp = new ValidParentheses();
		boolean flag = vp.isValid(s);
		System.out.println("Valid: " + flag);
	}
}
