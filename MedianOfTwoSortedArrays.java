package com.leetcode;

public class MedianOfTwoSortedArrays {
	/**
	 * 如果m+n是偶数，需要将中间的两个数加起来除以2，否则就是中间那个数
	 * 在求解中位数的时候可以等效于变成求数组合并后的第k大的数
	 * @param A
	 * @param B
	 * @return
	 */
	public double findMedianSortedArrays(int A[], int B[]) {
		int k = A.length + B.length;
	    return k % 2 == 0 ?  
	    		(findK(A, 0, A.length - 1, B, 0, B.length - 1, k/2 + 1) + 
	    		findK(A, 0, A.length - 1, B, 0, B.length - 1, k/2)) / 2
	    		: findK(A, 0, A.length - 1, B, 0, B.length - 1, k/2 + 1);
	    }

	//返回两个数组中第k大的元素。
	public double findK(int a[], int s1, int e1, int b[], 
			int s2, int e2, int k) {
	    int m = e1 - s1 + 1;
	    int n = e2 - s2 + 1;
	    if (m > n) 
	    	return findK(b, s2, e2, a, s1, e1, k); //a的长度比b的小。
	    if (s1 > e1) 
	    	return b[s2 + k - 1];
	    if (k == 1) 
	    	return Math.min(a[s1], b[s2]);
	    int midA = Math.min(k/2, m);
	    int midB = k - midA; 
	    //如果a的第midA大的元素比b的第midB大的元素小，
	    //那么删掉a的前midA个元素，在剩余的数中找第k-midA大的。
	    if (a[s1 + midA - 1] < b[s2 + midB - 1]) 
	        return findK(a, s1 + midA, e1, b, s2, e2, k - midA);
	    else if (a[s1 + midA - 1] > b[s2 + midB - 1]) 
	        return findK(a, s1, e1, b, s2 + midB, e2, k - midB);
	    else
	        return a[s1 + midA - 1];
	}
	
	public static void main(String[] args) {
		MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
		int A[] = {};
		int B[] = {1};
		double median = motsa.findMedianSortedArrays(A, B);
		System.out.println("median: " + median);
	}

}
