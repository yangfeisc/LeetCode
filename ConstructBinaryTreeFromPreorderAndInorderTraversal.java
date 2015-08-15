package com.leetcode;


/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * @author yangfei
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) 
        	return null;
        return builder(preorder, inorder, 0, 
        		preorder.length-1, 0, preorder.length-1);
    }

    public TreeNode builder(int[] preorder, int [] inorder, int pb, 
    		int pe, int ib , int ie) {
        int idx = -1;
        for(int i=0; i<inorder.length; i++) {
        	if(inorder[i] == preorder[pb]) {
        		idx = i;
        		break;
        	}
        }
        TreeNode root = new TreeNode(preorder[pb]);
        int len = idx - ib;

        if (idx > ib) {
            root.left = builder(preorder, inorder, 
            		pb+1, pb+len, ib, idx-1);
        }

        if (idx < ie) {
            root.right = builder(preorder, inorder, 
            		pb+len+1, pe, idx+1, ie);
        }

        return root;
    }

	public static void main(String[] args) {
		int[] pre = {1,2,3};
		int[] in = {1,2,3};
		ConstructBinaryTreeFromPreorderAndInorderTraversal ct =
				new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		TreeNode root = ct.buildTree(pre, in);
		System.out.println(root.val);
 	}
}
