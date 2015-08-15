package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the k-th row of the Pascal's 
 * triangle. For example, given k = 3, Return [1,3,3,1].
 * Could you optimize your algorithm to use only O(k) 
 * extra space?
 * @author yangfei
 *
 */
public class PascalTriangleII {
	/**
	 * ��Pascal Triangle��˶�������ҵ�E[i][j]=E[i-1][j-1]+E[i-1][j]; i,j>1
	 * ���Կ���ʹ�õݹ��������ֻ������һ�е�������������һ�С�
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<Integer>();
		result.add(1);
		if(rowIndex == 0) {
			return result;
		}
		List<Integer> nextRes = new ArrayList<Integer>();
		for(int i=1; i<=rowIndex; i++) {
			nextRes.add(1);
			for(int j=1; j<i; j++) {
				nextRes.add(result.get(j-1) + result.get(j));
			}
			nextRes.add(1);
			result = nextRes;      //����һ�н���滻Ϊ��ǰ�н����Ϊ��һ�μ���׼��
			nextRes = new ArrayList<Integer>(); //��գ�Ϊ������һ����׼��
		}
		
		return result;
    }
	
	public static void main(String[] args) {
		PascalTriangleII pt = new PascalTriangleII();
		int index = 2;
		List<Integer> result = pt.getRow(index);
		for(Object ele : result) {
			System.out.print(ele + "\t");
		}
	}
}
