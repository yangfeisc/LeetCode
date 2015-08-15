package com.leetcode;

/**
 * No extra space used to solve the problem.
 * If the number of a element is more than twice,
 * the element treats as duplicate.
 * 
 * ÿ���ж�ǰ���Ƿ��������Ԫ���뵱ǰԪ����ͬ�������ͬ����ǰԪ�غ��ƣ�
 * ��������ڣ��򽫵�ǰԪ�ؿ�����ǰ�档
 * @author yangfei
 *
 */
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] A) {
        if(A.length <= 2)
        	return A.length;
        int pre = 1;
        int cur = 2;
        while(cur < A.length) {
        	if(A[cur] == A[pre] && A[cur] == A[pre-1]) {
        		cur++;
        	} else {
        		pre++;
				A[pre] = A[cur];
				cur++;
        	}
        }
        return pre + 1;
    }
	
	public static void main(String[] args) {
		int[] A = new int[]{1,1,1,2};
		RemoveDuplicatesfromSortedArrayII rd = new RemoveDuplicatesfromSortedArrayII();
		int result = rd.removeDuplicates(A);
		System.out.println(result);
	}
}
