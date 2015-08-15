package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows: The left subtree of a node contains 
 * only nodes with keys less than the node's key. The right subtree of a node 
 * contains only nodes with keys greater than the node's key. Both the left 
 * and right subtrees must also be binary search trees.
 * @author yangfei
 *
 */
public class ValidateBinarySearchTree {
	/**
	 * BST中序遍历结果是一个递增序列
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
        List<Integer> list = inOrder(root, new ArrayList<Integer>());
        if(list.size() == 0 || list.size() == 1)
        	return true;
        for(int i=1; i<list.size(); i++) {
        	if(list.get(i) <= list.get(i-1))
        		return false;
        }
        return true;
    }
	
	public List<Integer> inOrder(TreeNode root, List<Integer> result) {
		if(root == null)
			return result;
		inOrder(root.left, result);
		result.add(root.val);
		inOrder(root.right, result);
		return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(8);
		ValidateBinarySearchTree vs = new ValidateBinarySearchTree();
		System.out.println(vs.isValidBST(root));
	}
}
