package com.leetcode;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * @author yangfei
 *
 */
public class ReverseLinkedListII {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
	        next = null;
	    }
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || m == n || head.next == null)
        	return head;
        ListNode virHead = new ListNode(-1);
        virHead.next = head;
        ListNode fast = virHead;
        ListNode slow = virHead;
        ListNode preM = virHead;
        ListNode mNode = virHead;
        int step = 1;
        while(step <= n) {
        	if(step < m) {
        		preM = preM.next;
        	} else if(step == m) {
        		mNode = preM.next;
        		slow = mNode;
        		fast = slow.next;
        	} else {
        		ListNode temp = slow;  //交换相邻两个元素
        		slow = fast;
        		if(step < n) {
        			fast = fast.next;
        		} else {
        			preM.next = fast;  //将preM的next指针指向第n个元素
            		mNode.next = fast.next; //将第m个元素的next指针指向第n个元素的next。
        		}
        		slow.next = temp;
        	}
        	step++;
        }
        return virHead.next;
    }
	
	public static void main(String[] args) {
		ReverseLinkedListII rl = new ReverseLinkedListII();
		ListNode head = rl.new ListNode(1);
		head.next = rl.new ListNode(2);
		head.next.next = rl.new ListNode(3);
//		head.next.next.next = rl.new ListNode(4);
//		head.next.next.next.next = rl.new ListNode(5);
		ListNode result = rl.reverseBetween(head, 2, 3);
		while(result != null) {
			System.out.print(result.val + "\t");
			result = result.next;
		}
	}
}
