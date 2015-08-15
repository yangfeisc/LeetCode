package com.leetcode;

public class PartionList {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		    next = null;
		}
	}
	public ListNode partition(ListNode head, int x) {
	       if(head == null || head.next == null) {
				return head;
			}
			ListNode virHead = new ListNode(-1);
			virHead.next = head;
			ListNode preMove = virHead;
			ListNode prePos = virHead;
			ListNode pos = prePos.next;
			while(preMove.next != null) {
				if(preMove.next.val >= x) {
					prePos = preMove;
					pos = prePos.next;
					break;
				}
				preMove = preMove.next;
			}
			while(preMove.next != null) {
				if(preMove.next.val < x) {
					ListNode move = preMove.next;
					preMove.next = move.next;
					move.next = pos;
					prePos.next = move;
					prePos = prePos.next;
				} else {
					preMove = preMove.next;
				}
			}
			return virHead.next;
	}
}
