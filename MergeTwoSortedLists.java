package com.leetcode;

/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 * @author yangfei
 *
 */
public class MergeTwoSortedLists {

	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) {
	    	val = x;
	        next = null;
	    }
	}
	 
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode virHead = new ListNode(-1);
		ListNode move = virHead;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				move.next = l1;
				l1 = l1.next;
			} else {
				move.next = l2;
				l2 = l2.next;
			}
			move = move.next;
		}
		if(l1 != null)
			move.next = l1;
		if(l2 != null)
			move.next = l2;
		
		return virHead.next;
	}
	
	public static void main(String[] args) {
		MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
		ListNode h1 = mtsl.new ListNode(1);
		h1.next = mtsl.new ListNode(3);
		h1.next.next = mtsl.new ListNode(5);
		
		ListNode h2 = mtsl.new ListNode(2);
		h2.next = mtsl.new ListNode(6);
		
		ListNode h = mtsl.mergeTwoLists(h1, h2);
		while(h != null) {
			System.out.print(h.val + "\t");
			h = h.next;
		}
	}
}
