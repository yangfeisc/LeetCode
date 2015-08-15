package com.leetcode;

public class SameTree {
	 
	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { 
	    	val = x; 
	    }
	}

	public class Solution {
	    public boolean isSameTree(TreeNode p, TreeNode q) {
	        if((p == null && q == null))
	        	return true;
	    	if(p == null && q != null) 
	        	return false;
	        if(p != null && q == null)
	        	return false;
	    	if(p.val != q.val) {
	        	return false;
	        }
	        
	        boolean left = isSameTree(p.left, q.left);
	        if(!left)
	        	return false;
	        boolean right = isSameTree(p.right, q.right);
	        if(!right)
	        	return false;
	        
	        return true;
	        
	    }
	}
}
