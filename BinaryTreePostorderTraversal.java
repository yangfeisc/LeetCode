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
	 * 后序遍历规则：左-右-根
	 * 方法一： 递归实现
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
	 * 迭代实现，使用栈实现，出栈得到节点顺序为根右左，每次向list最开头插入元素
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root) {
		if(root == null)
			return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);   //首先将根节点压栈
		while(!stack.isEmpty()) {
			TreeNode ele = stack.pop(); //首先出栈的为根节点，其后先出右子节点，后出左子节点
			if(ele.left != null)
				stack.push(ele.left);  //将左子节点压栈
			if(ele.right != null) {
				stack.push(ele.right); //将右子节点压栈
			}
			result.add(0, ele.val); //因为出栈顺序为“根右左”，所以需要每次将元素插入list开头
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
