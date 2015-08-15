package com.leetcode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the 
 * values in the list, only nodes itself can be changed.
 * @author yangfei
 *
 */
public class SwapNodesInPairs {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while(p2 != null) {
            int val = p1.val;
            p1.val = p2.val;
            p2.val = val;
            p1 = p2.next;
            if(p1 == null)
                break;
            else 
                p2 = p1.next;
        }
        return head;
    }
}
