package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [ [2],
 *   [3,4],
 *   [6,5,7],
 *   [4,1,8,3]
 * ] 
 * The minimum path sum from top to bottom is 11 
 * (i.e., 2 + 3 + 5 + 1 = 11).
 * Bonus point if you are able to do this using only O(n) extra space, 
 * where n is the total number of rows in the triangle.
 * @author yangfei
 *
 */
public class Triangle {
	/**
	 * 动态规划，从上到下
	 * @param triangle
	 * @return
	 */
	public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle.size() == 0)
        	return 0;
        int maxLen = triangle.get(triangle.size()-1).size();
        List<Integer> res = new ArrayList<Integer>(maxLen);
        for(int i=0; i<maxLen; i++) {
        	if(i < triangle.get(0).size())
        		res.add(triangle.get(0).get(i));
        	else 
        		res.add(Integer.MAX_VALUE);
        }
        for(int i=1; i<triangle.size(); i++) {
        	List<Integer> tmp = new ArrayList<>();
        	for(int j=0; j<maxLen; j++) {
        		if(j < triangle.get(i).size()) {
        			int value = triangle.get(i).get(j);
        			if(j == 0) {
        				if(j == res.size() - 1)
        					value += res.get(j);
        				else 
        					value += Math.min(res.get(j), res.get(j+1));
        			} else {
        				if(j == res.size() - 1)
        					value += res.get(j-1);
        				else if(j<res.size()-1)
        					value += Math.min(res.get(j-1), Math.min(res.get(j), res.get(j+1)));
        				else if(j == res.size()-1)
        					value += Math.min(res.get(j-1), res.get(j));
        			}
        			tmp.add(value);
        		} else 
        			tmp.add(Integer.MAX_VALUE);
        	}
        	res = tmp;
        	System.out.println("test: " + Arrays.toString(res.toArray()));
        }
        int result = res.get(0);
        for(int i=1; i<res.size(); i++)
        	result = Math.min(result, res.get(i));
        return result;
	}
	
	/**
	 * 动态规划，从下到上遍历
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size()];
        for(int i = 0; i < triangle.size(); i++) 
        	res[i] = triangle.get(triangle.size() - 1).get(i);

        for(int i = triangle.size() - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
               if(res[j] > res[j+1]) 
            	   res[j] = res[j+1] + triangle.get(i).get(j);
               else
            	   res[j] += triangle.get(i).get(j);
            }
        }
        return res[0];
    }
	
	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tem = new ArrayList<Integer>();
		tem.add(-1);
		list.add(tem);
		tem = new ArrayList<>();
		tem.add(3);
		tem.add(2);
		list.add(tem);
		tem = new ArrayList<>();
		tem.add(-3);
		tem.add(1);
		tem.add(-1);
		list.add(tem);
		Triangle tr = new Triangle();
		System.out.println(tr.minimumTotal1(list));
		System.out.println(tr.minimumTotal(list));
	}
}
