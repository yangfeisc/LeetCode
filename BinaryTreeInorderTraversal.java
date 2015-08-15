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
	 * �����������:��-��-��
	 * ����һ��ʹ�õݹ�ʵ��
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
	 * ����ʵ�֣��������ν����ӽڵ�ȫ������ջ�У����Ե�һ��whileѭ����ջ��Ԫ�ض�Ӧһ����������
	 * ���ӽڵ㣬Ȼ�󽫸�Ԫ�س�ջ����list�����жϸ�Ԫ�صı����ýڵ����������
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		do {
			//���ν���ڵ������ջ��
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
