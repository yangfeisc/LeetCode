package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Note:Recursive solution is trivial, could you do it iteratively?
 * ǰ���������-��-��
 * @author yangfei
 *
 */
public class BinaryTreePreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x; 
		}
	}
	
	List<Integer> result = new ArrayList<Integer>();
	
	/**
	 * ����ʵ�֣�ά��һ��ջ����Ϊ��ջ˳���ո����������ջ��������Ƚ�����ջ��Ȼ���ջ���ӽڵ㣬
	 * ����ջ���ӽڵ㡣
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null) 
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			result.add(node.val);
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null) 
				stack.push(node.left);
		}
		return result;
	}
	
	/**
	 * �ݹ����ǰ�������ǰ��������򣺸�-��-��
	 * @param root
	 * @return
	 */
//	public List<Integer> preorderTraversal(TreeNode root) {
//        if(root == null)
//        	return result;
//        result.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return result;
//    }
	
	public static void main(String[] args) {
		BinaryTreePreorderTraversal bp = new BinaryTreePreorderTraversal();
		TreeNode root = bp.new TreeNode(3);
		root.left = bp.new TreeNode(4);
		root.left.left = bp.new TreeNode(3);
		root.left.right = bp.new TreeNode(6);
		root.right = bp.new TreeNode(5);
		List<Integer> list = bp.preorderTraversal(root);
		for(Integer ll : list) {
			System.out.print(ll + "\t");
		}
		System.out.println();
	}
}

