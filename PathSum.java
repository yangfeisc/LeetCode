package com.leetcode;

public class PathSum {
	/**
	 * Definition for binary tree
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null)
			return false;
		if (isLeaf(root)) {
			if(root.val == sum)
				return true;
			else 
				return false;
		}
		boolean left = hasPathSum(root.left, sum-root.val);
		if(left)
			return true;
		else 
			return hasPathSum(root.right, sum-root.val);
	}
	
	public boolean isLeaf(TreeNode node) {
		if(node != null && node.left == null 
				&& node.right == null)
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		PathSum ps = new PathSum();
		TreeNode root = ps.new TreeNode(2);
		root.left = ps.new TreeNode(3);
		root.right = ps.new TreeNode(4);
		boolean flag = ps.hasPathSum(root, 2);
		System.out.println(flag);
	}
}
