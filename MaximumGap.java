package com.leetcode;

/**
 * Given an unsorted array, find the maximum difference between the successive
 * elements in its sorted form. 找到排序后相邻元素的最大差值。 Try to solve it in linear
 * time/space. Return 0 if the array contains less than 2 elements. You may
 * assume all elements in the array are non-negative integers and fit in the
 * 32-bit signed integer range.
 * 
 * @author yangfei
 * 
 */
public class MaximumGap {
	/**
	 * 先排序，在遍历找出最大的差值， 时间复杂度O(nlogn)
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
	 * 使用桶排序，最大的gap>=(max-min)/(len-1)，所以如果每个桶的大小为gap，
	 * 则最大间隔肯定不会在桶之间产生，肯定会在桶间产生，这样只需要保存每个桶的最大值和最小值即可。
	 * @param num
	 * @return
	 */
	public int maximumGap(int[] num) {
		if (num == null || num.length < 2)
			return 0;
		int min = num[0];  //最小值
		int max = num[0];  //最大值
		for (int e : num) {
			min = min<e ? min : e;
			max = max>e ? max : e;
		}
		int gap = (max - min) / (num.length - 1) + 1;
		int[] bucketMIN = new int[num.length-1]; //桶中最小值集合
		int[] bucketMAX = new int[num.length-1]; //桶中最大值集合
		for(int i=0; i<num.length-1; i++) {
			bucketMIN[i] = Integer.MAX_VALUE;
			bucketMAX[i] = Integer.MIN_VALUE;
		}
		for (int e : num) {
			if (e == min || e == max)
				continue;
			int bIndex = (e - min) / gap; //元素对应的桶的索引
			bucketMIN[bIndex] = Math.min(e, bucketMIN[bIndex]);
			bucketMAX[bIndex] = Math.max(e, bucketMAX[bIndex]);
		}
		int maxGap = Integer.MIN_VALUE;
		int previous = min;
		for (int i = 0; i < num.length-1; i++) {
			if (bucketMIN[i] == Integer.MAX_VALUE
					&& bucketMAX[i] == Integer.MIN_VALUE)  //空桶
				continue;
			//当前桶最小值减去前一个非空桶的最大值得到gap
			maxGap = Math.max(maxGap, bucketMIN[i] - previous);
			//前一个非空桶的最大值
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
