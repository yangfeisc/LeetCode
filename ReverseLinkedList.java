package com.leetcode;

/**
 * Reverse a singly linked list.
 * @author yangfei
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode cur = head;
        ListNode move = head.next;
        cur.next = null;
        while(move != null) {
            ListNode tmp = move;
            move = move.next;
            tmp.next = cur;
            cur = tmp;
        }
        return cur;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
		ReverseLinkedList rl = new ReverseLinkedList();
		ListNode res = rl.reverseList(head);
//		System.out.println(res.next.next.next.val);
		while(res != null) {
			System.out.print(res.val + "\t");
			res = res.next;
		}
		System.out.println();
	}
}
