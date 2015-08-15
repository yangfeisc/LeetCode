package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers 
 * out of 1 ... n.
 * For example, If n = 4 and k = 2, a solution is:
 * [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
 * @author yangfei
 *
 */
public class Combinations {
	/**
	 * 递归
	 * new ArrayList<>(k)分配大小为k的List
	 * @param n
	 * @param k
	 * @return
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
 		combinations(result, new ArrayList<Integer>(k), 1, n, k);
 		return result;
    }
	
	public void combinations(List<List<Integer>> result, List<Integer> temp,
			int start, int end, int k) {
		if(k == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for(int i=start; i<=end; i++) {
			temp.add(i);
			combinations(result, temp, i+1, end, k-1);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		Combinations com = new Combinations();
		List<List<Integer>> result = com.combine(4, 2);
		for(int i=0; i<result.size(); i++) {
			System.out.println(Arrays.toString(result.get(i).toArray()));
		}
	}
}
