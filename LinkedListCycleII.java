package com.leetcode;

/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 * @author yangfei
 *
 */
public class LinkedListCycleII {
	
	/**
	 * 方法一：在定义ListNode对象时添加一个标志位flag，然后在方法中定义一个
	 * ListNode对象，使用这个对象进行遍历链表，如果节点的flag=0，则将其置为
	 * 1，表明已经遍历过，如果遍历到一个节点对应的flag为1，则表明该节点已经遍历过，
	 * 即链表存在环。时间复杂度：O(n)，空间复杂度O(1)，但是对象的空间复杂度增加了
	 * O(n)
	 * @param head
	 * @return
	 */
//	public ListNode detectCycle(ListNode head) {
//        if(head == null || head.next == null)
//        	return null;
//        ListNode ln = head;
//        while(ln != null) {
//        	if(ln.flag == 1) 
//        		return ln;
//        	ln.flag = 1;
//        	ln = ln.next;
//        }
//        return null;
//    }
	
	/**
	 * 方法二：定义两个对象指针，一个慢指针，一个快指针，慢指针每次遍历一个节点，快指针将遍历所有的节点，
	 * 判断这个过程中快慢指针会不会相同，如果会就是有环，输出此时对应的慢指针即可。
	 * 时间复杂度O(n^2)，空间复杂度O(1)。
	 * 运行超时！
	 * @param head
	 * @return
	 */
//	public ListNode detectCycle(ListNode head) {
//		if(head == null || head.next == null)
//			return null;
//		ListNode slow = head;
//		ListNode fast;
//		while(slow != null) {
//			fast = slow.next;
//			if(fast.next == null)
//				return null;
//			ListNode faster = fast.next;  //用于有环时跳出内层循环
//			while(faster != null && faster.next != null) {
//				if(fast == slow)
//					return slow;
//				if(fast == faster)
//					break;
//				fast = fast.next;
//				faster = faster.next.next;
//			}
//			slow = slow.next;
//		}
//		return null;
//	}
	
	/**
	 * 首先使用快慢指针判断是否有环，如果有环记录快慢指针相遇时走的步数，两者的差值即为环的大小，
	 * 然后将快慢指针均置为head，先让快指针走环的大小步，然后同时移动快慢指针，直到两者相遇即为
	 * 环的头，时间复杂度O(n)，空间复杂度O(1)。
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if(head==null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode fast = head.next;
		int slowStep = 0;
		int fastStep = 0;
		while(fast != null && fast.next != null) {
			++slowStep;
			fastStep = fastStep + 2;
			if(fast == slow )
				break;
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast == null || fast.next == null)
			return null;
		fast = head;
		slow = head;
		int step = fastStep - slowStep;
		while(step > 0) {
			fast = fast.next;
			step--;
		}
		while(fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;
	}
	
	public static void main(String[] args) {
		LinkedListCycleII llc = new LinkedListCycleII();
		ListNode head = llc.new ListNode(3);
		head.next = llc.new ListNode(2);
		head.next.next = llc.new ListNode(5);
		head.next.next.next = head.next;
		System.out.println(llc.detectCycle(head).val);
		
	}
	
	public class ListNode {
		int val;
//		int flag = 0;
		ListNode next;
		ListNode(int x) {
			val = x;
	        next = null;
	    }
	}
}
