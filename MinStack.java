package com.leetcode;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * @author yangfei
 *
 */
public class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minStack = new Stack<Integer>();
	
	//peek():得到栈的栈顶元素
	public void push(int x) {
        if(minStack.isEmpty() || minStack.peek() >= x)
        	minStack.push(x);
        stack.push(x);
    }

    public void pop() {
        if(minStack.peek().equals(stack.peek()))
        	minStack.pop();
        stack.pop();
        
    }

    public int top() {
		return stack.peek();
    }

    public int getMin() {
		return minStack.peek();
    }
    
    public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(5);
		ms.push(1);
		ms.push(3);
		System.out.println("top: " + ms.top());
		System.out.println("getMin: " + ms.getMin());
		System.out.println("Before Pop: ");
		while(!ms.minStack.isEmpty()) {
			System.out.println(ms.minStack.peek());
			ms.pop();
		}
		ms.push(5);
		ms.push(1);
		ms.push(3);
		ms.pop();
		System.out.println("After Pop: ");
		while(!ms.minStack.isEmpty()) {
			System.out.println(ms.minStack.peek());
			ms.pop();
		}
	}
}
