package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' 
 * values. (ie, from left to right, then right to left for the next level and 
 * alternate between).
 * For example: Given binary tree {3,9,20,#,#,15,7},
 *      3
 *     / \
 *    9  20
 *      /  \
 *     15   7
 * return its zigzag level order traversal as:
 * [[3],[20,9],[15,7]]
 * @author yangfei
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null)
			return result;
		Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
        int line = 1;
        List<Integer> temp = new ArrayList<>();
        queue.add(root);
        int size = queue.size();
        while(!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	size--;
        	if(line % 2 == 0)  //修改加入的顺序，实现Z字形输出
        		temp.add(0, node.val);
        	else 
        		temp.add(node.val);
        	if(node.left != null)
        		queue.add(node.left);
        	if(node.right != null)
        		queue.add(node.right);
        	if(size == 0) {
        		result.add(temp);
        		temp = new ArrayList<>();
        		size = queue.size();
        		line++;
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
		BinaryTreeZigzagLevelOrderTraversal bt = new BinaryTreeZigzagLevelOrderTraversal();
		List<List<Integer>> list = bt.zigzagLevelOrder(root);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
