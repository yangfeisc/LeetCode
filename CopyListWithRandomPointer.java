package com.leetcode;

/**
 * A linked list is given such that each node contains an additional random 
 * pointer which could point to any node in the list or null.
 * Return a deep copy of the list.  即只拷贝对应节点的值，但是不共用地址
 * @author yangfei
 *
 */
public class CopyListWithRandomPointer {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { 
			this.label = x; 
		}
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) 
			return null;
        RandomListNode copyHead = null, copyCur = null;
        RandomListNode cur = head;
        while(cur != null) { //将新节点连接到原节点后
        	if(cur == head) {
        		copyHead = new RandomListNode(head.label);
        		cur = head.next;
        		head.next = copyHead;
        		copyHead.next = cur;
        	} else {
        		copyCur = new RandomListNode(cur.label);
        		copyCur.next = cur.next;
        		cur.next = copyCur;
        		cur = copyCur.next;
        	}
        }
        cur = head;
        while(cur != null) {  //设置random指针
        	if(cur.random != null) 
        		cur.next.random = cur.random.next;
        	cur = cur.next.next;
        }
        cur = head;
        copyCur = copyHead;
        while(copyCur.next != null) {  //恢复两个链表
        	cur.next = copyCur.next;
        	cur = cur.next;
        	copyCur.next = cur.next;
        	copyCur = copyCur.next;
        }
        cur.next = null;
        return copyHead;
    }
	
	public static void main(String[] args) {
		CopyListWithRandomPointer cw = new CopyListWithRandomPointer();
		RandomListNode head = cw.new RandomListNode(1);
		head.next = cw.new RandomListNode(2);
//		head.next.next = cw.new RandomListNode(3);
		head.random = head.next;
		RandomListNode ch = cw.copyRandomList(head);
		while(ch != null) {
			System.out.print(ch.label + " -> ");
			ch = ch.next;
		}
	}
}
