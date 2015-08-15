package com.leetcode;

/**
 * A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below). The robot can only 
 * move either down or right at any point in time. The robot 
 * is trying to reach the bottom-right corner of the grid 
 * (marked 'Finish' in the diagram below). 
 * How many possible unique paths are there?
 * m and n will be at most 100
 * @author yangfei
 *
 */
public class UniquePaths {
	/**
	 * �ݹ飬����һ����Ӧ��·����+����һ����Ӧ��·����
	 * ��ʱ
	 * @param m
	 * @param n
	 * @return
	 */
//	public int uniquePaths1(int m, int n) {
//        if(m == 1 || n == 1)
//        	return 1;
//		return uniquePaths1(m-1, n) + uniquePaths1(m, n-1);
//    }
	
	/**
	 * �������ԭ�������˱��뾭��(m+n-2)���ߵ��յ㣬��������m-1��������n-1��
	 * ���Կ���ʹ�ô�(m+n-2)������ȡ(m-1)�����Ŀ�����Ϊ���Ľ��
	 * @param m
	 * @param n
	 * @return
	 */
	public int uniquePaths2(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
		long result = 1; //�������
		for(int i=1; i<=n-1; i++) {
			result *= m - 1 + i;
			result /= i;
		}
		return (int)result;
	}
	
	/**
	 * ʹ��һ��m*n�ľ��󱣴浽��ǰλ�õ�·��������(i,j)λ�õ�·��������(i-1,j)��(i,j-1)��·����֮�ͣ�
	 * ������д������󷵻�(m-1,n-1)��Ӧ�����ּ�Ϊ����
	 * ʱ�临�Ӷ�O(m*n)���ռ临�Ӷ�O(m*n)
	 * @return
	 */
	public int uniquePaths3(int m, int n) {
		if(m == 1 || n == 1)
			return 1;
		int[][] result = new int[m][n];
		result[0][0] = 1;
		for (int i = 1; i < n; i++) {
			result[0][i] = result[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			result[i][0] = result[i - 1][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				result[i][j] = result[i - 1][j] + result[i][j - 1];
			}
		}
		return result[m - 1][n - 1];
	}
	
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths2(10, 10));
		System.out.println(up.uniquePaths3(10, 10));
	}
}
