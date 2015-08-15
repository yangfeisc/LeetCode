package com.leetcode;

/**
 * Given an array of non-negative integers, you are initially positioned at 
 * the first index of the array. Each element in the array represents your 
 * maximum jump length at that position. Your goal is to reach the last 
 * index in the minimum number of jumps.
 * For example: Given array A = [2,3,1,1,4] 
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step 
 * from index 0 to 1, then 3 steps to the last index.)
 * @author yangfei
 *
 */
public class JumpGameII {
	/**
	 * step:需要跳的步数，
	 * curIndex：经过step步能到达的最远距离；
	 * curMax：从0~i，能到达的最远距离。
	 * 如果curIndex<i，则需要多跳一步，并将curIndex变为curMax。
	 * @param A
	 * @return
	 */
	public int jump(int[] A) {
		if(A.length<=0 || A.length==1)
			return 0;
		if(A[0] >= A.length)
			return 0;
			
		int step = 0;
		int curIndex = 0;
		int curMax = 0;
        for(int i=0; i<A.length; i++) {
        	if(curIndex < i) {
        		step++;
        		curIndex = curMax;
        	}
        	curMax = Math.max(curMax, i+A[i]);
        }
        
        return step;
    }
	
	public static void main(String[] args) {
		int[] A = {6,2,6,1,7,9,3,5,3,7,2,8,9,4,7,7,2,2,8,4,6,6,1,3};
		JumpGameII jp = new JumpGameII();
		System.out.println(jp.jump(A));
	}
}
