package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreetoLinkedList {
	List<TreeNode> list = new ArrayList<TreeNode>();
	
	public void flatten(TreeNode root) {
		while(root != null) {
			if(root.left != null) {
				TreeNode t = root.left;
				//��root�����������ҽڵ�t�ӵ�root������������ԭ���������ӵ�t�ҽڵ�
				while(t.right != null) {
					t = t.right;
				}
				t.right = root.right;
				root.right = root.left;
				root.left = null;
			}
			root = root.right;
		}
    }
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	public static void main(String[] args) {
		FlattenBinaryTreetoLinkedList bp = new FlattenBinaryTreetoLinkedList();
		TreeNode root = bp.new TreeNode(3);
		root.left = bp.new TreeNode(4);
		root.left.left = bp.new TreeNode(3);
		root.left.right = bp.new TreeNode(6);
		root.right = bp.new TreeNode(5);
		bp.flatten(root);
		while(root != null) {
			System.out.println(root.val);
			root = root.right;
		}
	}
}
