package com.leetcode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:Can you solve it without using extra space?
 * @author yangfei
 *
 */
public class LinkedListCycle {
	/**
	 * 使用快慢指针，如果有环，快慢指针肯定会相遇
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
        if (head==null || head.next==null)
        	return false;
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null) {
        	if(fast == slow)
        		return true;
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return false;
    }
	
	public static void main(String[] args) {
		LinkedListCycle llc = new LinkedListCycle();
		ListNode head = llc.new ListNode(3);
		head.next = llc.new ListNode(2);
//		head.next.next = llc.new ListNode(5);
//		head.next.next.next = head.next;
		System.out.println(llc.hasCycle(head));
		
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
	        next = null;
	    }
	}
}


