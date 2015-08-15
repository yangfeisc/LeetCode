package com.leetcode;

/** 
 * ע�⣺������Ԫ��Ϊ�����������룬��˴�ǰ���ǻ���ɽ����׼ȷ
 * ֱ�۵Ľⷨ���Ӻ���ǰ���α���������ÿ�����ܵ�������������ĵ�
 * @author yangfei
 */
public class JumpGame {
	public boolean canJump(int[] A) {
		if(A.length == 0) {
			return true;
		}
		if(A.length == 1) {
			return true;
		}
		
		return recursion(A, A.length-1);
    }
	
	
	public boolean recursion(int[] A, int n) {
		if (n <= 0) {
			return true;
		} else {
			for(int i = n-1; i>=0; i--) {
				if(i + A[i] >= n) {
					return recursion(A, n-1);
				}
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		int[] A = {2, 0};
		boolean flag = jg.canJump(A);
		System.out.println(flag);
	}
}
