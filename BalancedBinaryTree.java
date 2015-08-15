package com.leetcode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * A height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never 
 * differ by more than 1.
 * @author yangfei
 * 
 */
public class BalancedBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if(root == null)
			return true;
		if(getDiff(root) == -1)
			return false;
		return true;
	}
	
	/**
	 * 判断左右子树的高度差是否超过1
	 * @param root
	 * @return
	 */
	public int getDiff(TreeNode root) {
		if(root == null)
			return 0;
		
		int left = getDiff(root.left);
		int right = getDiff(root.right);
		if(left == -1 || right == -1)
			return -1;
		if(Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}
	
	public static void main(String[] args) {
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		TreeNode root = bbt.new TreeNode(1);
		root.right = bbt.new TreeNode(2);
		root.right.right = bbt.new TreeNode(3);
		System.out.println(bbt.isBalanced(root));
	}
}
