package com.leetcode;


public class SortList_Insertion {

	/**
	 * 排序过程中如果发现两个节点的顺序有误，可以通过改变这两个节点中对应的值，而不是调换整个节点 
	 * @param head
	 * @return
	 */
	public ListNode insertionSortList(ListNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
//		ListNode cur = head.next;  
//	    while(cur != null) {  
//	    	ListNode tmp = head;  
//	        while(tmp.val < cur.val && tmp != cur)  
//	        	tmp = tmp.next;  
//	        if(tmp != cur) {  
//	            while(tmp != cur) {  
//	               int tmpvalue = tmp.val;  
//	               tmp.val = cur.val;  
//	               cur.val = tmpvalue;  
//	               tmp = tmp.next;  
//	            }  
//	        }  
//	        cur = cur.next;  
//	    }  
//	    return head;  
	        
		ListNode virHead = new ListNode(0);  //添加一个虚拟的头结点
		ListNode compare = virHead;
		ListNode move = head;
		
		while(move != null) {
			ListNode fence = move.next;
			compare = virHead;
			while(compare.next != null 
					&& compare.next.val <= move.val) {
				compare = compare.next;
			}
			move.next = compare.next;
			compare.next = move;
			move = fence;
		}
		return virHead.next;
	}
	
	public static void main(String[] args) {
		SortList_Insertion si = new SortList_Insertion();
		ListNode head = new ListNode(3);
		ListNode fence = head;
		for(int i=0; i<10; i++) {
			ListNode temp = new ListNode(i%5);
			fence.next = temp;
			fence = fence.next;
		}
		ListNode out = head;
		while(out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}
		
		System.out.println();
		
		ListNode t = si.insertionSortList(head);
		
		System.out.println("output");
		out = t;
		while(out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;
	
	public ListNode(int x) {
		val = x;
		next = null;
	}
}
