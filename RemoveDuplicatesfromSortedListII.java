package com.leetcode;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * @author yangfei
 *
 */
public class RemoveDuplicatesfromSortedListII {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode virHead = new ListNode(-1);
		ListNode move = virHead;
		ListNode fast = head.next;
		ListNode slow = head;
		int count = 1;
		while(fast != null) {
			if(fast.val == slow.val) {
				count++;
			} else {
				if(count == 1) {
					move.next = slow;
					slow = slow.next;
					move = move.next;
				} else {
					count = 1;
					slow = fast;
				}
			}
			fast = fast.next;
			if(fast == null) {
				if(count > 1)
					slow = fast;
				move.next = slow;
			}
		}
		return virHead.next;
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedListII rd = new RemoveDuplicatesfromSortedListII();
		ListNode head = rd.new ListNode(1);
		head.next = rd.new ListNode(2);
		head.next.next = rd.new ListNode(2);
		head.next.next.next = rd.new ListNode(2);
		ListNode h = rd.deleteDuplicates(head);
		while(h != null) {
			System.out.print(h.val + "\t");
			h = h.next;
		}
	}
}
