package com.leetcode;

import java.util.List;

public class MergeKSortedLists {
	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	/**
	 * ���÷���˼�룬���Ƚ�k�����зֳ����飬Ȼ��ݹ�Ĺ鲢��һ�������С�
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		return divide(lists, 0, lists.size() - 1);
	}

	private ListNode divide(List<ListNode> lists, int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			return merge(divide(lists, l, m), divide(lists, m + 1, r));
		}
		return lists.get(l);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode virHead = new ListNode(0);
		virHead.next = l1;
		ListNode cur = virHead;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				cur.next = l1;
				l1 = l1.next;
			} else {
				cur.next = l2;
				l2 = l2.next;
			}
			cur = cur.next;
		}
		if (l1 != null)
			cur.next = l1;
		if (l2 != null)
			cur.next = l2;
		return virHead.next;
	}
}
