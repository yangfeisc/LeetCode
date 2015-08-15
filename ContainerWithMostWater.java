package com.leetcode;

public class ContainerWithMostWater {
	
	/**
	 * 方法一：依次遍历数组元素得到每次遍历的最大值，时间复杂度O(N^2)
	 * 该方法超时。
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
