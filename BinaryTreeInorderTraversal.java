package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the midorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author yangfei
 *
 */
public class BinaryTreeInorderTraversal {
	
	private List<Integer> result = new ArrayList<Integer>();
	
	/**
	 * 中序遍历规则:左-根-右
	 * 方法一：使用递归实现
	 * @param root
	 * @return
	 */
//	public List<Integer> midorderTraversal(TreeNode root) {
//		if(root == null) 
//			return result;
//		midorderTraversal(root.left);
//		result.add(root.val);
//		midorderTraversal(root.right);
//		return result;
//	}
	
	/**
	 * 迭代实现，首先依次将左子节点全部加入栈中，所以第一个while循环后栈顶元素对应一个子树的最
	 * 左子节点，然后将该元素出栈加入list，并判断该元素的遍历该节点的右子树。
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		do {
			//依次将左节点均加入栈中
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			if (!stack.isEmpty()) {
				root = stack.pop();
				result.add(root.val);  
				root = root.right;
			}
		} while(!stack.isEmpty() || root != null);
		return result;
	}
	
	public static void main(String[] args) {
		BinaryTreeInorderTraversal bp = new BinaryTreeInorderTraversal();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.right = new TreeNode(5);
//		List<Integer> list = bp.midorderTraversal(root);
		List<Integer> list = bp.inorderTraversal(root);
		for(Integer ll : list) {
			System.out.print(ll + "\t");
		}
		System.out.println();
	}
}
