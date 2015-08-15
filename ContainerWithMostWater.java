package com.leetcode;

public class ContainerWithMostWater {
	
	/**
	 * ����һ�����α�������Ԫ�صõ�ÿ�α��������ֵ��ʱ�临�Ӷ�O(N^2)
	 * �÷�����ʱ��
	 * @param height
	 * @return
	 */
//	public int maxArea(int[] height) {
//      int result = 0;
//		int len = height.length;
//        for(int i=0; i<len; i++) {
//        	for(int j=0; j<len; j++) {
//        		int min = height[i]<height[j] ? height[i] : height[j];
//        		int product = (j - i) * min;
//       			result = result>product ? result : product;
//        	}
//        }
//        return result;
//    }
	
	public int maxArea(int[] height) {
        int res = 0;
        int begin = 0, end = height.length-1;
        int low = 0, area = 0;
        while(begin < end) {
            if(height[begin] < height[end]) {
                low = height[begin];
                area = low * (end - begin);
                while(height[++begin] < low);
            } else {
                low = height[end];
                area = low * (end - begin);
                while(height[--end] < low);
            }
            res = res>area ? res : area;
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] height = new int[]{1,3,2,1,4,2};
		ContainerWithMostWater cwmw = new ContainerWithMostWater();
		int result = cwmw.maxArea(height);
		System.out.println(result);
	}
}
