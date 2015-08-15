package com.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
		int len = num.length;
        int minDiff = Integer.MAX_VALUE;  //��С�Ĳ���
        int closestSum = Integer.MAX_VALUE;  //��С�ĺ�
        for(int i=0; i<len-1; i++) {
        	int newTarget = target - num[i];
        	int j = i + 1;
        	int k = len - 1;
        	while(j < k) {
        		int sum = num[i] + num[j] + num[k];
        		if(sum == target)
        			return target;
        		if(num[j]+num[k]>newTarget) {
        			k--;
        		} else {
        			j++;
        		}
        		int diff = Math.abs(target - sum); 
        		if(minDiff > diff) {
        			minDiff = diff;
        			closestSum = sum;
        		}
        	}
        }
        return closestSum;
    }
	
	public static void main(String[] args) {
		int[] num = new int[]{1, 1, 1, 0};
		int target = -100;
		ThreeSumClosest tsc = new ThreeSumClosest();
		System.out.println(tsc.threeSumClosest(num, target));
	}
}
