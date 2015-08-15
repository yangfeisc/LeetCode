package com.leetcode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time 
 * and return its modified list. If the number of nodes is not a multiple 
 * of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * @author yangfei
 *
 */
public class ReverseNodesInkGroup {
	//Definition for singly-linked list.
	public class ListNode {
		int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null 
        		|| k == 0 || k == 1)
        	return head;

        ListNode virHead = new ListNode(0);
        virHead.next = head;
        ListNode preGroup = virHead;
        ListNode move = head;
        boolean canReverse = true;
        while(canReverse) {
        	//判断后面还能不能反转。
        	for(int i=0; i<k; i++) {
        		if(move == null) {
        			canReverse = false;
        			break;
        		}
        		move = move.next;
        	}
        	//如果可以反转，就反转。
        	if(canReverse) {
        		ListNode nextGroupHead = move;  
                move = preGroup.next;  
                ListNode tmp = move;  
                preGroup.next = null;  
                for (int i = 0; i < k; ++i) {  
                    ListNode next = move.next;  
                    move.next = preGroup.next;  
                    preGroup.next = move;  
                    move = next;  
                }  
                canReverse = true;  
                preGroup = tmp;  
                preGroup.next = nextGroupHead;  
                move = nextGroupHead;  
            }  
        }
        return virHead.next;
    }
	
	public static void main(String[] args) {
		ReverseNodesInkGroup rig = new ReverseNodesInkGroup();
		ListNode head = rig.new ListNode(1);
		head.next = rig.new ListNode(2);
		head.next.next = rig.new ListNode(3);
		head.next.next.next = rig.new ListNode(4);
		rig.reverseKGroup(head, 2);
		ListNode p = head;
		while(p != null) {
			System.out.print(p.val + "\t");
			p = p.next;
		}
	}
}
