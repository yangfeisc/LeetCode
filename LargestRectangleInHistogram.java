package com.leetcode;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
 * find the area of largest rectangle in the histogram.
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * For example, Given height = [2,1,5,6,2,3], return 10.
 * @author yangfei
 *
 */
public class LargestRectangleInHistogram {
	/**
	 * 超时。时间复杂度O(n^2)
	 * @param height
	 * @return
	 */
	public int largestRectangleArea1(int[] height) {
        if(height.length == 0)
        	return 0;
        int maxArea = height[0];
        int len = height[0];
        for(int i=1; i<height.length; i++) {
        	len = height[i];
        	for(int j=i-1; j>=0; j--) {
        		len = Math.min(len, height[j]);
        		maxArea = Math.max(maxArea, len*(i-j+1));
        	}
        }
        return maxArea;
    }
	
	/**
	 * 使用一个栈维护一个递增的序列
	 * @param height
	 * @return
	 */
	public int largestRectangleArea2(int[] height) {
		if(height.length == 0)
			return 0;
		int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for (int i=0; i <= height.length; i++){
            int h = (i==len ? 0 : height[i]);  //在数组结尾添加一个0，为了最后将所有元素出栈。
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            } else {
                while(!s.isEmpty() && h < height[s.peek()]) { //所有比当前大的值全部弹出
                	int tp = s.pop();
                	maxArea = Math.max(maxArea, height[tp]
                			* (s.isEmpty() ? i : i-1-s.peek()));
                }
                s.push(i);
            }
        }
        return maxArea;
	}
	
	public static void main(String[] args) {
		int[] height = {4,2,0,3,2,4,3,4};
		LargestRectangleInHistogram lr = new LargestRectangleInHistogram();
		System.out.println(lr.largestRectangleArea1(height));
		System.out.println(lr.largestRectangleArea2(height));
	}
}
