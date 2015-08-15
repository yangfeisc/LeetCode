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
	 * 使用二分法的思想，首先通过对行进行二分，找出target可能处的行，
	 * 然后对找到的行进行二分找出target是否存在于这行中。
	 * 时间复杂度O(logm + logn)
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
        //先找到target可能处在的行
        int rowb = 0;
        int rowe = m - 1;
        int mid = 0;
        while(rowb < rowe) {
        	mid = (rowe + rowb) >>> 1; ////右移一位，相当于除以2相当于除以2
        	if(matrix[mid][n-1] == target)
        		return true;
        	else if(matrix[mid][n-1] > target)
        		rowe = mid;
        	else 
        		rowb = mid + 1;
        }
        //找到target可能处在的列
        int colb = 0;
        int cole = n - 1;
        while(colb < cole) {
        	mid = (colb + cole) >>> 1;  ////右移一位，相当于除以2，相当于除以2
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
	 * 方法二：运用一次二分法，直接找到矩阵中间的那个元素
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
			int row = mid / n;  //行
			int col = mid % n;  //列
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
