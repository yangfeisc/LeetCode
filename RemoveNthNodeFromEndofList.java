package com.leetcode;

/**
 * This problem asks return the Nth element of a singly-linked
 * list from the end, only once visit will be used.
 * 
 * Algorithm: two pointer can be used to visit the list,
 * the faster is N step faster than the slower one. When the
 * faster one reach the end of the list, the slower's position 
 * will be Nth from the end.
 * 
 * @author yangfei
 *
 */
public class RemoveNthNodeFromEndofList {
//	 Definition for singly-linked list.
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
	         next = null;
	     }
	 }
	 
	 public ListNode removeNthFromEnd(ListNode head, int n) {
		 if(head == null)
			 return head;
		 ListNode fastPointer = head;
		 ListNode slowPointer = head;
		 ListNode virHead = new ListNode(-1);
		 virHead.next = head;
		 ListNode tempPointer = virHead;
		 int i = 1;
		 while(i<=n) {
			 fastPointer = fastPointer.next;
			 i++;
		 }
		 while(fastPointer != null) {
			 fastPointer = fastPointer.next;
			 tempPointer = slowPointer;
			 slowPointer = slowPointer.next;
		 }
		 tempPointer.next = slowPointer.next;
		 return virHead.next;
	 }
	 
	 public static void main(String[] args) {
		 RemoveNthNodeFromEndofList rd = new RemoveNthNodeFromEndofList();
		 ListNode head = rd.new ListNode(1);
//		 head.next = rd.new ListNode(2);
//		 head.next.next = rd.new ListNode(3);
//		 head.next.next.next = rd.new ListNode(4);
//		 head.next.next.next.next = rd.new ListNode(5);
			
		 ListNode result = rd.removeNthFromEnd(head, 1);
		 ListNode temp = result;
		 while(temp != null) {
			 System.out.print(temp.val + "->");
			 temp = temp.next;
		}
		
	}
}
