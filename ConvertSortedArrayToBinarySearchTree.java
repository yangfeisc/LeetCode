package com.leetcode;


/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author yangfei
 *
 */
public class ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] num) {
		if(num.length == 0)
			return null;
		int len = num.length;
		return createBST(num, 0, len-1);
    }
	
	public TreeNode createBST(int[] num, int begin, int end) {
		if(begin > end) 
			return null;
		int mid = (begin + end) / 2;
		TreeNode root = new TreeNode(num[mid]);
		TreeNode left = createBST(num, begin, mid-1);
		TreeNode right = createBST(num, mid+1, end);
		root.left = left;
		root.right = right;
		
		return root;
	}
}
