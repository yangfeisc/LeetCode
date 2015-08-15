package com.leetcode;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] �� num[i+1], find a peak element 
 * and return its index. The array may contain multiple peaks, in that 
 * case return the index to any one of the peaks is fine. You may imagine 
 * that num[-1] = num[n] = -��.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your 
 * function should return the index number 2.
 * Your solution should be in logarithmic complexity.
 * @author yangfei
 *
 */
public class FindPeakElement {
	/**
	 * ��Ϊ�������Ҷ��Ǹ����������ֻ��Ҫ�����жϵ�ǰԪ����
	 * ���ұ�Ԫ�صĴ�С��������ұ�ֵС����������ұ���������ǰԪ�ؾ�������
	 * @param num
	 * @return
	 */
	public int findPeakElement(int[] num) {
		int begin = 0;
		int end = num.length - 1;
		int mid;
		while(begin < end) {
			mid = (end + begin) / 2;
			if(num[mid] < num[mid+1])
				begin = mid + 1;
			else
				end = mid;
		}
		return begin;
    }
	
	public static void main(String[] args) {
		int[] num = {1};
		FindPeakElement pe = new FindPeakElement();
		System.out.println(pe.findPeakElement(num));
	}
}
