package com.leetcode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * @author yangfei
 *
 */
public class RotateList {
	/**
	 * 使用两个指针，找到右边要移动的节点。
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) 
            return head;
        ListNode slow = head, fast = head;
        int len = 0, step = 0;
        while(fast != null) {
        	fast = fast.next;
        	len++;
        }
        if(len <= k) 
        	k %= len;
        if(k == 0)
        	return head;
        fast = head;
        while(step < k) {
        	fast = fast.next;
        	step++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode result = slow.next;
        slow.next = null;
        fast.next = head;
        return result;
    }
	
	public static void main(String[] args) {
		RotateList rl = new RotateList();
		ListNode head = rl.new ListNode(1);
//		head.next = rl.new ListNode(2);
//		head.next.next = rl.new ListNode(3);
//		head.next.next.next = rl.new ListNode(4);
//		head.next.next.next.next = rl.new ListNode(5);
		ListNode p = rl.rotateRight(head, 1);
		while(p != null) {
			System.out.print(p.val + "\t");
			p = p.next;
		}
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
