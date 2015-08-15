package com.leetcode;

/**
 * ��һ���ź����listת��Ϊһ�����������(BST)
 * BST�����������ǿգ������������нڵ�ֵ��С�ڸ��ڵ�ֵ
 * 	          ���������ǿգ������������нڵ�ֵ�����ڸ��ڵ�ֵ
 * @author yangfei
 *
 */
public class ConvertSortedListToBinarySearchTree {
	
	//Definition for singly-linked list.
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) { 
	    	val = x; 
	    	next = null; 
	   	} 
	}

	//Definition for binary tree
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { 
			val = x; 
		}
	}
	
	static ListNode h;
	
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
        	return null;
        h = head;
        int len = 0;
        ListNode node = head;
        while(node != null) {
        	len++;
        	node = node.next;
        }
        return createBST(0, len-1);
    }
	
	public TreeNode createBST(int begin, int end) {
		if(begin > end)
			return null;
		int mid = (end + begin) / 2;
		TreeNode left = createBST(begin, mid-1);
		TreeNode root = new TreeNode(h.val);
		root.left = left;
		h = h.next;
		
		TreeNode right = createBST(mid+1, end);
		root.right = right;
		
		return root;
	}
	
	public static void main(String[] args) {
		ConvertSortedListToBinarySearchTree cstst = 
				new ConvertSortedListToBinarySearchTree();
		ListNode head = cstst.new ListNode(1);
		head.next = cstst.new ListNode(3);
		head.next.next = cstst.new ListNode(4);
		head.next.next.next = cstst.new ListNode(6);
		head.next.next.next.next = cstst.new ListNode(8);
		TreeNode root = cstst.sortedListToBST(head);
		System.out.println(root.val);
	}
}
