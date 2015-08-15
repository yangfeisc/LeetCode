package com.leetcode;

/**
 * Given a binary tree, find its maximum depth. The maximum depth is the number 
 * of nodes along the longest path from the root node down to the farthest leaf node.
 * @author yangfei
 *
 */
public class MaximumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        return travserTree(root);
    }
	
	public int travserTree(TreeNode root) {
		if(root == null)
			return Integer.MIN_VALUE;
		if(root.left == null && root.right == null)
			return 1;
		int left = travserTree(root.left) + 1;
		int right = travserTree(root.right) + 1;
		return left>right ? left : right;
	}
	
	public static void main(String[] args) {
		MaximumDepthOfBinaryTree mt = new MaximumDepthOfBinaryTree();
		TreeNode root = mt.new TreeNode(1);
		root.left = mt.new TreeNode(2);
//		root.right = mt.new TreeNode(3);
		int result = mt.maxDepth(root);
		System.out.println(result);
	}
}
