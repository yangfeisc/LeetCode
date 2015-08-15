package com.leetcode;

public class ReorderList {
//	Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public void reorderList(ListNode head) {  
		if (head == null || head.next == null) {  
			return;  
	    }  
	  
	    // find the second half head  
	    ListNode fast = head;  
	    ListNode slow = head;  
	    while (fast != null && fast.next != null) {  
	    	fast = fast.next.next;  
	        slow = slow.next;  
	    }  
	  
	    // reverse the second half  
	    ListNode p = slow.next; // first list
	    slow.next = null; 		// second list  
	    ListNode pPre = null;  
	    ListNode pSuf = p;  
	    while (p != null) {  
	    	pSuf = p.next;  
	        p.next = pPre;  
	        pPre = p;  
	        p = pSuf;  
	    }  
	  
	    // combine two halves  
	    ListNode l1 = head;  
	    ListNode l2 = pPre;  
	    while (l1 != null && l2 != null) {  
	    	ListNode l1Next = l1.next;  
	        ListNode l2Next = l2.next;  
	        l1.next = l2;  
	        l2.next = l1Next;  
	        l1 = l1Next;  
	        l2 = l2Next;  
	    } 
	}
	
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		ListNode head = rl.new ListNode(1);
		head.next = rl.new ListNode(2);
//		head.next.next = rl.new ListNode(3);
//		head.next.next.next = rl.new ListNode(4);
		rl.reorderList(head);
		ListNode node = head;
		while(node != null) {
			System.out.print(node.val + "\t");
			node = node.next;
		}
		System.out.println();
	}
}
