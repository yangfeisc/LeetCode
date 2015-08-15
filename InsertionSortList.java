package com.leetcode;

/**
 * Sort a linked list using insertion sort.
 * @author yangfei
 *
 */
public class InsertionSortList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode virHead = new ListNode(0); // ���һ�������ͷ���
		ListNode compare = virHead;
		ListNode move = head;

		while (move != null) {
			ListNode fence = move.next;
			compare = virHead;
			while (compare.next != null && compare.next.val <= move.val) {
				compare = compare.next;
			}
			move.next = compare.next;
			compare.next = move;
			move = fence;
		}
		return virHead.next;
	}
}
