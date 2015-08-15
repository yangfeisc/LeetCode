package com.leetcode;

/**
 * Populate each next pointer to point to its next right node. If there is no next 
 * right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * You may only use constant extra space. You may assume that it is a perfect binary 
 * tree (i.e., all leaves are at the same level, and every parent has two children).
 * For example, Given the following perfect binary tree,
 *         1 
 *       /  \
 *      2    3
 *     / \  / \
 *    4  5  6  7
 * After calling your function, the tree should look like:
 *         1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * @author yangfei
 *
 */
public class PopulatingNextRightPointersInEachNode {
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
        root.next = null;
        connect(root.left);
        connect(root.right);
        mergeConn(root.left, root.right);
    }
	
	public void mergeConn(TreeLinkNode left, TreeLinkNode right) {
		while(left != null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
	}
}
