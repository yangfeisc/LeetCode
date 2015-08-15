package com.leetcode;

/**
 * What if the given tree could be any binary tree? Would your previous solution
 * still work? Note: You may only use constant extra space. 
 * For example, Given the following binary tree, 
 * 			1 
 * 		   / \ 
 * 		  2   3 
 *		 / \   \ 
 *		4   5   7 
 * After calling your function, the tree should look like: 
 * 			1 -> NULL 
 * 		   / \ 
 * 		  2 ->3 -> NULL 
 * 	     / \   \ 
 *      4-> 5 ->7 -> NULL
 * @author yangfei
 * 
 */
public class PopulatingNextRightPointersInEachNodeII {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}

	public void connect(TreeLinkNode root) {
		if(root == null) 
			return;
		TreeLinkNode parent = root;
		TreeLinkNode nextLine;
		TreeLinkNode current;
		while(parent != null) {
			nextLine = null;
			current = null;
			while(parent != null) {
				if(nextLine == null) {   
					nextLine = parent.left!=null ? parent.left:parent.right;
				}
				if(parent.left != null) {
					if(current != null) {
						current.next = parent.left;
					}
					current = parent.left;
				}
				if(parent.right != null) {
					if(current != null) {
						current.next = parent.right;
					}
					current = parent.right;
				}
				parent = parent.next;
			}
			parent = nextLine;
		}
    }
	
}
