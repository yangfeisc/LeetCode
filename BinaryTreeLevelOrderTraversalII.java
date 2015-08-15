package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (i.e., from left to right, level by level from leaf to root) 
 * For example: Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [[15,7],[9,20],[3]]
 * @author yangfei
 *
 */
public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
        queue.add(root);
        List<Integer> temp = new ArrayList<>();
        int size = queue.size();
        while(!queue.isEmpty()) {
        	TreeNode tn = queue.poll();
        	size--;
        	temp.add(tn.val);
        	if(tn.left != null)
        		queue.add(tn.left);
        	if(tn.right != null)
        		queue.add(tn.right);
        	if(size == 0) {
        		result.add(0, temp);
        		size = queue.size();
        		temp = new ArrayList<>();
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);
		BinaryTreeLevelOrderTraversalII bt = new BinaryTreeLevelOrderTraversalII();
		List<List<Integer>> list = bt.levelOrderBottom(root);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
