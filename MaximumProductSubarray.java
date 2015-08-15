package com.leetcode;

/**
 * @author yangfei
 */
public class MaximumProductSubarray {
	
	/**
	 * ����һ��ʹ�ö�̬�滮ʵ�ֳ��ֳ�ʱ����̬�滮ʱ�临�Ӷ�ΪO(n^2)
	 * @param A
	 * @return
	 */                                                                                                      
	public int maxProduct_DP(int[] A) {
		int result = 0, size = A.length;
		if(size <= 0) 
			return 0;
		if(size == 1)
			return A[0];
		for(int i=0; i<size; i++) {
			int product = 1;
			for(int j=i; j<size; j++) {
				product *= A[j];
				if(product > result) {
					result = product;
				}
			}
		}
		return result;
	}
	
	/**
	 * ��������ʹ��������������ǰ��Ľ����ʱ�临�Ӷ�O(n)
	 * @param A
	 * @return
	 */
	public int maxProduct(int[] A) {
		if(A.length <= 0) return 0;  
        if(A.length == 1) return A[0];  
        int curMax = A[0];  
        int curMin = A[0];
        int result = A[0];
        for(int i=1; i<A.length; i++){  
            int temp = curMin * A[i];  
            curMin = Math.min(A[i], Math.min(temp, curMax*A[i]));  
            curMax = Math.max(A[i], Math.max(temp, curMax*A[i]));  
            result = Math.max(result, curMax);  
        }  
        return result>0 ? result:-1; 
	}
	
	public static void main(String[] args) {
		int[] A = {2, 3, 0, -4, -1};
		MaximumProductSubarray mps = new MaximumProductSubarray();
		int result1 = mps.maxProduct_DP(A);
		int result2 = mps.maxProduct(A);
		System.out.println(result1 + "\t" + result2);
	}
}
