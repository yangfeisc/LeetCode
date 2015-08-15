package com.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * @author yangfei
 *
 */
public class RecoverBinarySearchTree {
	TreeNode t1 = null;
    TreeNode t2 = null;
    TreeNode pre = null;
	/**
	 * 使用Morris遍历方法进行求解
	 * @param root
	 */
	public void recoverTree(TreeNode root) {
        
        errorNode(root);
        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
    }
	
	public void errorNode(TreeNode root) {
		if(root.left != null) {
			errorNode(root.left);
		}
		if(pre != null) {
			if (pre.val > root.val) {
				if(t1 == null) {
					t1 = pre;
					t2 = root;
				} else 
					t2 = root;
			}
		}
		pre = root;
		if(root.right != null) {
			errorNode(root.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(6);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(8);
		RecoverBinarySearchTree rb = new RecoverBinarySearchTree();
		rb.recoverTree(root);
		BinaryTreeInorderTraversal bi = new BinaryTreeInorderTraversal();
		List<Integer> list = bi.inorderTraversal(root);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
