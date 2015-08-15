package com.leetcode;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf 
 * path could represent a number. An example is the root-to-leaf path 
 * 1->2->3 which represents the number 123. 
 * Find the total sum of all root-to-leaf numbers.
 * @author yangfei
 *
 */
public class SumRoottoLeafNumbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	private int sum = 0;
	
	public int sumNumbers(TreeNode root) {
		if(root == null)
			return 0;
		DFSTravel(root, 0);
		return sum;
	}
	
	public void DFSTravel(TreeNode root, int s) {
		if(root.left == null && root.right == null) {
			sum = sum + (10*s + root.val);
			return;
		} 
		s = 10*s + root.val;
		if(root.left != null)
			DFSTravel(root.left, s);
		if(root.right != null)
			DFSTravel(root.right, s);
	}
	
	public static void main(String[] args) {
		SumRoottoLeafNumbers sr = new SumRoottoLeafNumbers();
		TreeNode root = sr.new TreeNode(0);
		root.left = sr.new TreeNode(1);
//		root.left.left = sr.new TreeNode(3);
//		root.left.right = sr.new TreeNode(6);
//		root.right = sr.new TreeNode(5);
		int result = sr.sumNumbers(root);
		System.out.println(result);
	}
}
