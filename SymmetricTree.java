package com.leetcode;

import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (i.e., 
 * symmetric around its center).
 * For example, this binary tree is symmetric:
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *   \   \
 *   3    3
 * Note: Bonus points if you could solve it both recursively and iteratively.
 * @author yangfei
 *
 */
public class SymmetricTree {
	/**
	 * 方法一：递归求解
	 * @param root
	 * @return
	 */
//	public boolean isSymmetric(TreeNode root) {
//        if(root == null)
//        	return true;
//        return sysmmetric(root.left, root.right);
//    }
//	
//	public boolean sysmmetric(TreeNode left, TreeNode right) {
//		if(left == null && right == null)
//			return true;
//		if(left == null || right == null)
//			return false;
//		if(left.val != right.val)
//			return false;
//		if(!sysmmetric(left.left, right.right) 
//				|| !sysmmetric(left.right, right.left))
//			return false;
//		return true;
//	}
	
	/**
	 * 方法二：迭代求解
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null || 
				(root.left==null && root.right==null))
			return true;
		if(root.left == null || root.right == null)
			return false;
		Stack<TreeNode> left = new Stack<>();
		Stack<TreeNode> right = new Stack<>();
		left.push(root.left);
		right.push(root.right);
		while(!left.isEmpty() && !right.isEmpty()) {
			TreeNode t1 = left.pop();
			TreeNode t2 = right.pop();
			if(t1 == null && t2 == null) 
				continue;
			if(t1 == null || t2 == null)
				return false;
			if(t1.val == t2.val) {
				left.push(t1.right);
				left.push(t1.left);
				right.push(t2.left);
				right.push(t2.right);
			} else 
				return false;
		}
		return true;
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
		SymmetricTree st = new SymmetricTree();
		TreeNode root = st.new TreeNode(3);
		root.left = st.new TreeNode(4);
		root.right = st.new TreeNode(4);
		root.left.left = st.new TreeNode(6);
		root.left.right = st.new TreeNode(3);
		root.right.left = st.new TreeNode(3);
		root.right.right = st.new TreeNode(6);
		System.out.println(st.isSymmetric(root));
	}
}
