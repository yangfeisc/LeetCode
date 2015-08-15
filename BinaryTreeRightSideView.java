package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 * 从二叉树的右边像左看，能看到多少节点，如果同一层右节点为空，则可以看到左节点。
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
	 * 使用Queue记录每一层对应的节点，然后按照先进先出，将每层的第一个节点保存到List中
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
        if(root == null)	return result;
        //定义一个Queue，保存树的每层节点。
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);  //将根节点加入队列
        while(!queue.isEmpty()) {
        	int size = queue.size();  //判断队列的大小，即上层节点个数
        	for(int i=0; i<size; i++) {
        		TreeNode tn = queue.poll(); //依次弹出上层节点，并将其子节点加入队列
        		if(i == 0)  //因为队列是先进先出，节点加入过程也是从右向左，所以每层最右节点就是每层第一个元素
        			result.add(tn.val); //将最右节点加入List结果集中
    			if(tn.right != null) queue.offer(tn.right); //首先向队列中加入右节点
        		if(tn.left != null) queue.offer(tn.left);   //向队列中加入左节点
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
