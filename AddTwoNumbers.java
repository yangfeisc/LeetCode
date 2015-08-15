package com.leetcode;

public class AddTwoNumbers {
	
//	Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
        	return null;
        }
		if(l1 == null) {
        	return l2;
        }
        if(l2 == null) {
        	return l1;
        }
		ListNode head = new ListNode(0);
		ListNode ln = head;
        boolean tail = false;
        int upbit = 0;
        while(l1 != null) {
        	if(l2 == null) {
        		tail = true;
        		break;
        	}
        	ListNode node = new ListNode(0);
        	int value = l1.val + l2.val + upbit;
        	if(value >= 10) {
        		node.val = value - 10;
        		upbit = 1;
        	} else {
        		node.val = value;
        		upbit = 0;
        	}
        	ln.next = node;
        	ln = ln.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        if(tail) {
        	while(l1 != null) {
        		if(upbit == 1) {
        			l1.val += upbit;
        			upbit = 0;
        			if(l1.val >= 10) {
        				l1.val = l1.val - 10;
        				upbit = 1;
        			}
        		}
        		ln.next = l1;
        		ln = ln.next;
        		l1 = l1.next;
        	}
        } else {
        	while(l2 != null) {
        		if(upbit == 1) {
        			l2.val += upbit;
        			upbit = 0;
        			if(l2.val >= 10) {
        				l2.val = l2.val - 10;
        				upbit = 1;
        			}
        		}
        		ln.next = l2;
        		ln = ln.next;
        		l2 = l2.next;
        	}
        }
        if(upbit == 1) {
        	ListNode node = new ListNode(0);
        	node.val = upbit;
        	ln.next = node;
        }
        return head.next;
    }
	public static void main(String[] args) {
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode p1 = atn.new ListNode(5);
		ListNode f1 = p1;
//		for(int i=0; i<10; i++) {
//			ListNode temp = atn.new ListNode(i%5);
//			f1.next = temp;
//			f1 = f1.next;
//		}
		f1 = p1;
		System.out.println("List 1: ");
		while(f1 != null) {
			System.out.print(f1.val + "\t");
			f1 = f1.next;
		}
		ListNode p2 = atn.new ListNode(5);
		ListNode f2 = p2;
		for(int i=0; i<5; i++) {
			ListNode temp = atn.new ListNode(9);
			f2.next = temp;
			f2 = f2.next;
		}
		f2 = p2;
		System.out.println("\nList 2: ");
		while(f2 != null) {
			System.out.print(f2.val + "\t");
			f2 = f2.next;
		}
		ListNode ln = atn.addTwoNumbers(p1, p2);
		System.out.println("\nresult: ");
		while(ln != null) {
			System.out.print(ln.val + "\t");
			ln = ln.next;
		}
	}
}
