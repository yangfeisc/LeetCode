package com.leetcode;

/**
 * Given n, how many structurally unique BST's (binary search 
 * trees) that store values 1...n?
 * For example, Given n = 3, there are a total of 5 unique BST's.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author yangfei
 *
 */
public class UniqueBinarySearchTrees {
	/**
	 * 使用迭代的方法，result数组中保存n前面元素相应的结果，然后根据n对应的结果与前面结果的关系建立递推关系
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
        if(n <= 1)
        	return 1;
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        
        for(int i=2; i<=n; i++) {
        	for(int j=0; j<i; j++) {
        		result[i] += result[j]*result[i-j-1];
        	}
        }
        return result[n];
    }
	
	public static void main(String[] args) {
		UniqueBinarySearchTrees ub = new UniqueBinarySearchTrees();
		System.out.println(ub.numTrees(3));
	}
}

