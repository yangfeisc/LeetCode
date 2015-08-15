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
	 * ����ͳ����������ĳ��ȣ�Ȼ�󳤵������ȱ�������̵���ͬ��Ȼ����������ͬʱ������
	 * ͬʱ�ж������Ƿ���ͬ����ͬ�ͷ��أ���ͬ�ͼ���ֱ�������β��ʱ�临�Ӷ�O(n),
	 * �ռ临�Ӷ�O(1)��
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
        //��һ������ĳ���
        while(pa != null) {
        	lenA++;
        	pa = pa.next;
        }
        //�ڶ�������ĳ���
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
