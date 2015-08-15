package com.leetcode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish 
 * Notation. Valid operators are +, -, *, /. Each operand may be an 
 * integer or another expression.
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author yangfei
 *
 */
public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<tokens.length; i++) {
			if(tokens[i].equals("+") || tokens[i].equals("-") 
					|| tokens[i].equals("*") || tokens[i].equals("/")) {
				int right = stack.pop();
				int left = stack.pop();
				if(tokens[i].equals("+"))
					stack.push(left + right);
				else if(tokens[i].equals("-"))
					stack.push(left - right);
				else if(tokens[i].equals("*"))
					stack.push(left * right);
				else if(tokens[i].equals("/"))
					stack.push(left / right);
			} else
				stack.push(Integer.parseInt(tokens[i]));
		}
		return stack.pop();
    }
}
