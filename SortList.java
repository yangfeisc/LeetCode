/**
 * 实现对于一个链表的排序，要求时间复杂度为O(nlogn)，空间复杂度为常量
 * 通过分析，可以采用归并排序,通过快慢指针找到链表的中间位置，然后进行归并。
 * 在比较两个节点的大小之后，通过交换两个节点对应的值来排序。
 */

package com.leetcode;

public class SortList {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
        	return head;
        }
        ListNode slow = head;  //慢指针，每次走一步
        ListNode fast = head;  //快指针，每次走两步
        //找到中间节点
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;  //一定要注意这句话不能漏
        return mergeList(sortList(head), sortList(mid));
    }
	
	public ListNode mergeList(ListNode list1, ListNode list2) {
		ListNode virHead = new ListNode(-1);
		ListNode loop = virHead;
		while(list1 != null && list2 != null) {
			if(list1.val <= list2.val) {
				loop.next = list1;
				list1 = list1.next;
			} else {
				loop.next = list2;
				list2 = list2.next;
			}
			loop = loop.next;
		}
		loop.next = list1 != null ? list1:list2;
		return virHead.next;
	}
	
	public static void main(String[] args) {
		SortList si = new SortList();
		ListNode head = si.new ListNode(3);
		ListNode fence = head;
		for(int i=0; i<10; i++) {
			ListNode temp = si.new ListNode(i%5);
			fence.next = temp;
			fence = fence.next;
		}
		ListNode out = head;
		while(out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}
		
		System.out.println();
		
		ListNode t = si.sortList(head);
		
		System.out.println("output");
		out = t;
		while(out != null) {
			System.out.print(out.val + " ");
			out = out.next;
		}
	}
}
