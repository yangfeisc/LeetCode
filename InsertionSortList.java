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
		ListNode virHead = new ListNode(0); // 添加一个虚拟的头结点
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
