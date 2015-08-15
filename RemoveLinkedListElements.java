package com.leetcode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * Example: Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * @author yangfei
 *
 */
public class RemoveLinkedListElements {
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
	
	public ListNode removeElements(ListNode head, int val) {
        if(head == null) 
        	return head;
        ListNode virHead = new ListNode(-1);
        virHead.next = head;
        ListNode fast = virHead;
        while(fast != null) {
        	while (fast.next != null && fast.next.val == val) {
        		ListNode slow = fast;
        		fast = fast.next;
        		slow.next = fast.next;
        		fast = slow;
        		if(fast.next == null)
        			break;
        	}
//        	if(fast.next == null)
//        		break;
        	fast = fast.next;
        }
        return virHead.next;
    }
	
	public static void main(String[] args) {
		RemoveLinkedListElements rd = new RemoveLinkedListElements();
		ListNode head = rd.new ListNode(1);
//		 head.next = rd.new ListNode(2);
//		 head.next.next = rd.new ListNode(6);
//		 head.next.next.next = rd.new ListNode(4);
//		 head.next.next.next.next = rd.new ListNode(6);
			
		 ListNode result = rd.removeElements(head, 2);
		 ListNode temp = result;
		 while(temp != null) {
			 System.out.print(temp.val + "->");
			 temp = temp.next;
		}
	}
}
