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
	 * ����һ���ڶ���ListNode����ʱ���һ����־λflag��Ȼ���ڷ����ж���һ��
	 * ListNode����ʹ�����������б�����������ڵ��flag=0��������Ϊ
	 * 1�������Ѿ������������������һ���ڵ��Ӧ��flagΪ1��������ýڵ��Ѿ���������
	 * ��������ڻ���ʱ�临�Ӷȣ�O(n)���ռ临�Ӷ�O(1)�����Ƕ���Ŀռ临�Ӷ�������
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
	 * ��������������������ָ�룬һ����ָ�룬һ����ָ�룬��ָ��ÿ�α���һ���ڵ㣬��ָ�뽫�������еĽڵ㣬
	 * �ж���������п���ָ��᲻����ͬ�����������л��������ʱ��Ӧ����ָ�뼴�ɡ�
	 * ʱ�临�Ӷ�O(n^2)���ռ临�Ӷ�O(1)��
	 * ���г�ʱ��
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
//			ListNode faster = fast.next;  //�����л�ʱ�����ڲ�ѭ��
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
	 * ����ʹ�ÿ���ָ���ж��Ƿ��л�������л���¼����ָ������ʱ�ߵĲ��������ߵĲ�ֵ��Ϊ���Ĵ�С��
	 * Ȼ�󽫿���ָ�����Ϊhead�����ÿ�ָ���߻��Ĵ�С����Ȼ��ͬʱ�ƶ�����ָ�룬ֱ������������Ϊ
	 * ����ͷ��ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)��
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
