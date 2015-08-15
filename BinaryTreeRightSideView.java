package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 * �Ӷ��������ұ����󿴣��ܿ������ٽڵ㣬���ͬһ���ҽڵ�Ϊ�գ�����Կ�����ڵ㡣
 * @author yangfei
 *
 */
public class BinaryTreeRightSideView {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	/**
	 * ʹ��Queue��¼ÿһ���Ӧ�Ľڵ㣬Ȼ�����Ƚ��ȳ�����ÿ��ĵ�һ���ڵ㱣�浽List��
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        if(root == null)	return result;
        //����һ��Queue����������ÿ��ڵ㡣
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);  //�����ڵ�������
        while(!queue.isEmpty()) {
        	int size = queue.size();  //�ж϶��еĴ�С�����ϲ�ڵ����
        	for(int i=0; i<size; i++) {
        		TreeNode tn = queue.poll(); //���ε����ϲ�ڵ㣬�������ӽڵ�������
        		if(i == 0)  //��Ϊ�������Ƚ��ȳ����ڵ�������Ҳ�Ǵ�����������ÿ�����ҽڵ����ÿ���һ��Ԫ��
        			result.add(tn.val); //�����ҽڵ����List�������
    			if(tn.right != null) queue.offer(tn.right); //����������м����ҽڵ�
        		if(tn.left != null) queue.offer(tn.left);   //������м�����ڵ�
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		BinaryTreeRightSideView bp = new BinaryTreeRightSideView();
		TreeNode root = bp.new TreeNode(3);
		root.left = bp.new TreeNode(4);
		root.left.left = bp.new TreeNode(3);
		root.left.right = bp.new TreeNode(6);
		root.right = bp.new TreeNode(5);
		List<Integer> result = bp.rightSideView(root);
		for(int i : result) {
			System.out.print(i + "\t");
		}
	}
}
