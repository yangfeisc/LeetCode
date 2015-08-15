package com.leetcode;

/**
 * Write an efficient algorithm that searches for a value in an 
 * m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer 
 * of the previous row.
 * For example,
 * Consider the following matrix:
 * [[1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]]
 * Given target = 3, return true.
 * @author yangfei
 *
 */
public class SearchA2DMatrix {
	/**
	 * ʹ�ö��ַ���˼�룬����ͨ�����н��ж��֣��ҳ�target���ܴ����У�
	 * Ȼ����ҵ����н��ж����ҳ�target�Ƿ�����������С�
	 * ʱ�临�Ӷ�O(logm + logn)
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
        	return false;
        int n = matrix[0].length;
        if(n == 0)
        	return false;
        //���ҵ�target���ܴ��ڵ���
        int rowb = 0;
        int rowe = m - 1;
        int mid = 0;
        while(rowb < rowe) {
        	mid = (rowe + rowb) >>> 1; ////����һλ���൱�ڳ���2�൱�ڳ���2
        	if(matrix[mid][n-1] == target)
        		return true;
        	else if(matrix[mid][n-1] > target)
        		rowe = mid;
        	else 
        		rowb = mid + 1;
        }
        //�ҵ�target���ܴ��ڵ���
        int colb = 0;
        int cole = n - 1;
        while(colb < cole) {
        	mid = (colb + cole) >>> 1;  ////����һλ���൱�ڳ���2���൱�ڳ���2
        	if(matrix[rowb][mid] == target)
        		return true;
        	else if(matrix[rowb][mid] > target)
        		cole = mid;
        	else 
        		colb = mid + 1;
        }
        return matrix[rowb][colb]==target;
    }
	
	/**
	 * ������������һ�ζ��ַ���ֱ���ҵ������м���Ǹ�Ԫ��
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean searchMatrix2(int[][] matrix, int target) {
		int m = matrix.length;
		if(m == 0)
			return false;
		int n = matrix[0].length;
		if(n == 0)
			return false;
		int begin = 0;
		int end = m * n - 1;
		while(begin <= end) {
			int mid = (end + begin) >>> 1; 
			int row = mid / n;  //��
			int col = mid % n;  //��
			if(matrix[row][col] == target)
				return true;
			else if(matrix[row][col] > target)
				end = mid - 1;
			else 
				begin = mid + 1;
		}
		return false;
//		return matrix[begin/n][begin%n]==target;
	}
	
	public static void main(String[] args) {
//		int[][] m = {{1,   3,  5,  7},
//				{10, 11, 16, 20}, 
//				{23, 30, 34, 50}};
		int[][] m = {{1,1},{2,2}};
		SearchA2DMatrix sm = new SearchA2DMatrix();
		System.out.println(sm.searchMatrix(m, 2));
		System.out.println(sm.searchMatrix2(m, 2));
	}
}
