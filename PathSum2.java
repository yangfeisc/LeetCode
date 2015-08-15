package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
	/**
	 * Definition for binary tree
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
        	return result;
        
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(root.val);
        subPathSum(root, sum-root.val, temp, result);
        
        return result;
    }
	
	public void subPathSum(TreeNode root, int sum, List<Integer> temp, 
			List<List<Integer>> result) {
		if(root == null)
			return;
		if(root.left==null && root.right==null && sum == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		if(root.left != null) {
			temp.add(root.left.val);
			subPathSum(root.left, sum-root.left.val, temp, result);
			temp.remove(temp.size()-1);
		}
		if(root.right != null) {
			temp.add(root.right.val);
			subPathSum(root.right, sum-root.right.val, temp, result);
			temp.remove(temp.size()-1);
		}
			
	}
	
	public static void main(String[] args) {
		PathSum2 ps = new PathSum2();
		TreeNode root = ps.new TreeNode(2);
		root.left = ps.new TreeNode(3);
		root.right = ps.new TreeNode(4);
		root.left.left = ps.new TreeNode(2);
		root.left.right = ps.new TreeNode(4);
		root.right.left = ps.new TreeNode(3);
		root.right.right = ps.new TreeNode(5);
		List<List<Integer>> result = ps.pathSum(root, 9);
		for(int i=0; i<result.size(); i++) {
			for(int j=0; j<result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + ",");
			}
			System.out.println();
		}
	}
}
