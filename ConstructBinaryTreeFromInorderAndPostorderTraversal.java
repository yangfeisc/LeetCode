package com.leetcode;


/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree
 * @author yangfei
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return builder(inorder, 0, inorder.length-1, 
				postorder, 0, postorder.length-1);
    }
	
	public TreeNode builder(int[] in, int ib, int ie, 
			int[] post, int pb, int pe) {
		if(ib > ie)
			return null;
		if(ib == ie)
			return new TreeNode(in[ib]);
		TreeNode root = new TreeNode(post[pe]);
		int index = 0;
		for(int i=ib; i<ie; i++) {
			if(in[i] == post[pe]) {
				index = i;
				break;
			}
		}
		int leftLen = index - ib;
		root.left = builder(in, ib, index-1, post, pb, leftLen+pb-1);
		root.right = builder(in, index+1, ie, post, pb+leftLen, pe-1);
		return root;
	}
	
}
