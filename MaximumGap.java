package com.leetcode;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form. �ҵ����������Ԫ�ص�����ֵ�� Try to solve it in linear
 * time/space. Return 0 if the array contains less than 2 elements. You may
 * assume all elements in the array are non-negative integers and fit in the
 * 32-bit signed integer range.
 * 
 * @author yangfei
 * 
 */
public class MaximumGap {
	/**
	 * �������ڱ����ҳ����Ĳ�ֵ�� ʱ�临�Ӷ�O(nlogn)
	 * 
	 * @param num
	 * @return
	 */
	// public int maximumGap(int[] num) {
	// if(num == null || num.length < 2)
	// return 0;
	// Arrays.sort(num);
	// int maxGap = 0;
	// for(int i=1; i<num.length; i++) {
	// maxGap = maxGap>(num[i]-num[i-1]) ? maxGap : (num[i]-num[i-1]);
	// }
	// return maxGap;
	// }

	/**
	 * ʹ��Ͱ��������gap>=(max-min)/(len-1)���������ÿ��Ͱ�Ĵ�СΪgap��
	 * ��������϶�������Ͱ֮��������϶�����Ͱ�����������ֻ��Ҫ����ÿ��Ͱ�����ֵ����Сֵ���ɡ�
	 * @param num
	 * @return
	 */
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2)
			return 0;
		int min = num[0];  //��Сֵ
		int max = num[0];  //���ֵ
		for (int e : num) {
			min = min<e ? min : e;
			max = max>e ? max : e;
		}
		int gap = (max - min) / (num.length - 1) + 1;
		int[] bucketMIN = new int[num.length-1]; //Ͱ����Сֵ����
		int[] bucketMAX = new int[num.length-1]; //Ͱ�����ֵ����
		for(int i=0; i<num.length-1; i++) {
			bucketMIN[i] = Integer.MAX_VALUE;
			bucketMAX[i] = Integer.MIN_VALUE;
		}
		for (int e : num) {
			if (e == min || e == max)
				continue;
			int bIndex = (e - min) / gap; //Ԫ�ض�Ӧ��Ͱ������
			bucketMIN[bIndex] = Math.min(e, bucketMIN[bIndex]);
			bucketMAX[bIndex] = Math.max(e, bucketMAX[bIndex]);
		}
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < num.length-1; i++) {
			if (bucketMIN[i] == Integer.MAX_VALUE
					&& bucketMAX[i] == Integer.MIN_VALUE)  //��Ͱ
				continue;
			//��ǰͰ��Сֵ��ȥǰһ���ǿ�Ͱ�����ֵ�õ�gap
			maxGap = Math.max(maxGap, bucketMIN[i] - previous);
			//ǰһ���ǿ�Ͱ�����ֵ
			previous = bucketMAX[i];
		}
		maxGap = Math.max(maxGap, max - previous); 
		return maxGap;
	}

	public static void main(String[] args) {
		int[] num = { 1,10000 };
		MaximumGap mg = new MaximumGap();
		System.out.println(mg.maximumGap(num));
	}
}
