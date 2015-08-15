package com.leetcode;

/**
 * No extra space used to solve the problem.
 * If the number of a element is more than twice,
 * the element treats as duplicate.
 * 
 * 每次判断前面是否存在两个元素与当前元素相同，如果相同，则当前元素后移，
 * 如果不存在，则将当前元素拷贝到前面。
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
