package com.leetcode;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * ��Ӱ�죬��Ϊ������ظ��Ļ�����ôû��ͨ�����ַ�����Сֵ������
 * 2,1,2,2,2,2��2,2,2,2,1,2���������������ͨ���ж�mid��0����len-1��Ӧ��Ԫ�رȽ�����Сֵ��
 * �������ͨ�����ַ��ҵ���Сֵ����ô��û���������Ϊ���Σ���ô��û��ͨ�����ֽ���������
 * Write a function to determine if a given target is in the array.
 * @author yangfei
 *
 */
public class SearchInRotatedSortedArrayII {
	/**
	 * ֱ�ӱ�����ʱ�临�Ӷ�ΪO(n)
	 * @param A
	 * @param target
	 * @return
	 */
	public boolean dirSearch(int[] A, int target) {
        for(int i=0; i<A.length; i++) {
        	if(A[i] == target)
        		return true;
        }
        return false;
    }
	
	public boolean search(int[] A, int target) {
        int begin = 0, end = A.length - 1;
		while(begin <= end) {
			int mid = (end + begin) / 2;
			if(A[mid] == target)
				return true;
			//��Ϊtarget��=A[mid]�����Բ�������κ���A[mid]��ͬ��Ԫ��
			while(A[begin] == A[mid] && begin < mid) 
				begin++;
			while(A[mid] == A[end] && mid < end)
				end--;
			//���begin=mid=end,˵��������Ԫ����ͬ���Ҷ��������target
			if(begin == mid && mid == end)
				return false;
			if(A[begin] <= target && target < A[mid])
				end = mid;
			else if(A[mid] < target && target <= A[end])
				begin = mid + 1;
			else if(A[begin] > A[mid])
				end = mid;
			else 
				begin = mid + 1;
		}
        return false;
    }
	
	public static void main(String[] args) {
		int[] A = {5,1,3};
		SearchInRotatedSortedArrayII si = new SearchInRotatedSortedArrayII();
		System.out.println(si.search(A, 3));
	}
}
