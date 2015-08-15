package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
 * @author yangfei
 *
 */
public class BinaryTreePostorderTraversal {
	
	private List<Integer> result = new ArrayList<Integer>();
	
	/**
	 * �������������-��-��
	 * ����һ�� �ݹ�ʵ��
	 * @param root
	 * @return
	 */
//	public List<Integer> postorderTraversal(TreeNode root) {
//        if(root == null)
//        	return result;
//        postorderTraversal(root.left);
//        postorderTraversal(root.right);
//        result.add(root.val);
//        
//        return result;
//    }
	
	/**
	 * ����ʵ�֣�ʹ��ջʵ�֣���ջ�õ��ڵ�˳��Ϊ������ÿ����list�ͷ����Ԫ��
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		if(root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);   //���Ƚ����ڵ�ѹջ
		while(!stack.isEmpty()) {
			TreeNode ele = stack.pop(); //���ȳ�ջ��Ϊ���ڵ㣬����ȳ����ӽڵ㣬������ӽڵ�
			if(ele.left != null)
				stack.push(ele.left);  //�����ӽڵ�ѹջ
			if(ele.right != null) {
				stack.push(ele.right); //�����ӽڵ�ѹջ
			}
			result.add(0, ele.val); //��Ϊ��ջ˳��Ϊ�������󡱣�������Ҫÿ�ν�Ԫ�ز���list��ͷ
		}
		return result;
	}
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static void main(String[] args) {
		BinaryTreePostorderTraversal bp = new BinaryTreePostorderTraversal();
		TreeNode root = bp.new TreeNode(3);
		root.left = bp.new TreeNode(4);
		root.left.left = bp.new TreeNode(3);
		root.left.right = bp.new TreeNode(6);
		root.right = bp.new TreeNode(5);
		List<Integer> list = bp.postorderTraversal(root);
		for(Integer ll : list) {
			System.out.print(ll + "\t");
		}
		System.out.println();
	}
	
}
