/**
 * ʵ�ֶ���һ�����������Ҫ��ʱ�临�Ӷ�ΪO(nlogn)���ռ临�Ӷ�Ϊ����
 * ͨ�����������Բ��ù鲢����,ͨ������ָ���ҵ�������м�λ�ã�Ȼ����й鲢��
 * �ڱȽ������ڵ�Ĵ�С֮��ͨ�����������ڵ��Ӧ��ֵ������
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
        ListNode slow = head;  //��ָ�룬ÿ����һ��
        ListNode fast = head;  //��ָ�룬ÿ��������
        //�ҵ��м�ڵ�
        while(fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;  //һ��Ҫע����仰����©
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
