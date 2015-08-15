package com.leetcode;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest 
 * path from the root node down to the nearest leaf node.
 * @author yangfei
 *
 */
public class MinimumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        return travserTree(root);
    }
	
	public int travserTree(TreeNode root) {
		if(root == null)
			return Integer.MAX_VALUE; 
		//因为是找到最近的叶子节点，所以必须两个同时为空
		if(root.left == null && root.right == null) {
			return 1;
		}
		int left = travserTree(root.left);
		int right = travserTree(root.right);
		
		return left < right ? left+1 : right+1;
	}
	
	public static void main(String[] args) {
		MinimumDepthOfBinaryTree mt = new MinimumDepthOfBinaryTree();
		TreeNode root = mt.new TreeNode(1);
		root.left = mt.new TreeNode(2);
//		root.right = mt.new TreeNode(3);
		int result = mt.minDepth(root);
		System.out.println(result);
	}
}
