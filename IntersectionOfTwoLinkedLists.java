package com.leetcode;

/**
 * Write a program to find the node at which the intersection 
 * of two singly linked lists begins.
 * Notes:
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * @author yangfei
 *
 */
public class IntersectionOfTwoLinkedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		    next = null;
		}
	}
	
	/**
	 * 首先统计两个链表的长度，然后长的链表先遍历到与短的相同，然后两个链表同时遍历，
	 * 同时判断两者是否相同，相同就返回，不同就继续直至链表结尾，时间复杂度O(n),
	 * 空间复杂度O(1)。
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, 
			ListNode headB) {
        if(headA == null || headB == null)
        	return null;
        int lenA = 0, lenB = 0;
        ListNode pa = headA;
        ListNode pb = headB;
        //第一个链表的长度
        while(pa != null) {
        	lenA++;
        	pa = pa.next;
        }
        //第二个链表的长度
        while(pb != null) {
        	lenB++;
        	pb = pb.next;
        }
        int diff = 0;
        pa = headA;
        pb = headB;
        if(lenA > lenB){
        	while(diff < lenA - lenB) {
        		pa = pa.next;
        		diff++;
        	}
        } else {
        	diff = 0;
        	while(diff < lenB - lenA) {
        		pb = pb.next;
        		diff++;
        	}
        }
        while((pa != null) && (pb != null)) {
    		if(pa.val == pb.val)
    			return pa;
    		pa = pa.next;
    		pb = pb.next;
    	}
        return null;
    }
	
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists it = new IntersectionOfTwoLinkedLists();
		ListNode headA = it.new ListNode(1);
		ListNode headB = it.new ListNode(1);
		ListNode result = it.getIntersectionNode(headA, headB);
		if(result == null)
			System.out.println("null");
		else 
			System.out.println(result.val);
	}
}
