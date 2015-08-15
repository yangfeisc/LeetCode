package com.leetcode;

public class RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;
	    ListNode(int x) {
	    	val = x;
	    	next = null;
	    }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) 
			return head;
		
		ListNode node1 = head;
		ListNode node2 = head.next;
		while(node2 != null) {
			if(node2.val == node1.val) {
				node2 = node2.next;
				node1.next = node2;
			} else {
				node1 = node2;
				node2 = node2.next;
			}
		}
		return head;
    }
	
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList rdfsl = new RemoveDuplicatesFromSortedList();
		ListNode head = rdfsl.new ListNode(1);
		head.next = rdfsl.new ListNode(1);
//		head.next.next = rdfsl.new ListNode(3);
		ListNode list = rdfsl.deleteDuplicates(head);
		ListNode p = list;
		while(p != null) {
			System.out.print(p.val + "->");
			p = p.next;
		}
		
	}
}
