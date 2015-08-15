package com.leetcode;

/**
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example: Given the below binary tree,
 *        1
 *       / \
 *      2   3
 * Return 6.
 * @author yangfei
 *
 */
public class BinaryTreeMaximumPathSum {
	int maxSum = Integer.MIN_VALUE;
	
	/**
	 * 递归，每次找到左子树的最长路径以及右子树的最长路径，同时找到左子树到根的最长路径以及右子树到根的最长路径
	 * 然后比较左子树最长路径、右子树最长路径以及左子树到根到右子树最长路径的最大者。
	 * @param root
	 * @return
	 */
	public int maxPathSum(TreeNode root) {
        Travsel(root);
        return maxSum;
    }
	
	public int Travsel(TreeNode root) {
		if(root == null)
			return 0;
		int left = Travsel(root.left);   
		int right = Travsel(root.right); 
		maxSum = Math.max(root.val, maxSum); 
		maxSum = Math.max(left + root.val, maxSum);  //左子树的最大路径和
		maxSum = Math.max(right + root.val, maxSum); //右子树的最大路径和
		maxSum = Math.max(left + right + root.val, maxSum); //左右子树的最大和以及整个树的最大路径
		return root.val + Math.max(0, Math.max(left, right));
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		BinaryTreeMaximumPathSum bt = new BinaryTreeMaximumPathSum();
		System.out.println(bt.maxPathSum(root));
	}
}
