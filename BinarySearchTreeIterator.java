package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and 
 * uses O(h) memory, where h is the height of the tree.
 * @author yangfei
 *
 */

/**
 * Your BinarySearchTreeIterator will be called like this:
 * BinarySearchTreeIterator i = new BinarySearchTreeIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class BinarySearchTreeIterator {
	List<Integer> list = new ArrayList<Integer>();
	int index = 0;
	public BinarySearchTreeIterator(TreeNode root) {
        traverse(root);
    }
	
	/**
	 * 中序遍历BST，得到一个有序的list
	 * @param root
	 */
	public void traverse(TreeNode root) {
		if(root != null) {
			traverse(root.left);
			list.add(root.val);
			traverse(root.right);
		}
	}
	
    /** 
     * @return whether we have a next smallest number 
     */
    public boolean hasNext() {
        return list.size()>index ? true : false;
    }

    /** 
     * 没有破坏数据
     * @return the next smallest number 
     */
    public int next() {
        return list.get(index++);
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		BinarySearchTreeIterator bst = new BinarySearchTreeIterator(root);
		while(bst.hasNext()) {
			System.out.print(bst.next() + "\t");
		}
		System.out.println();
	}
}

/**
 * Definition for binary tree
 */
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { 
    	val = x; 
    }
}
