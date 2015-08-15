package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中的元素只能唯一的一次用于组合出target
 * 使用递归求解
 * @author yangfei
 */
public class CombinationSumII {
	private List<List<Integer>> result = new ArrayList<>();
	private List<Integer> solu = new ArrayList<>();
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		int tail = candidates.length - 1;
		for(int i=candidates.length-1; i>=0; i--) {
			if(candidates[i] > target) {
				tail--;
			} else 
				break;
		}
		getCombination(candidates, target, 0, tail);
		return result;
	}

	public void getCombination(int[] candidates, int target, int sum, int level) {
		if (sum > target)
			return;
		if (sum == target) {
			if(!result.contains(solu))
				result.add(new ArrayList<>(solu));
			return;
		}
		for (int i = level; i >= 0; i--) {
			sum += candidates[i];
			solu.add(0, candidates[i]);
			getCombination(candidates, target, sum, i-1);
			solu.remove(0);
			sum -= candidates[i];
		}
	}
	
	public static void main(String[] args) {
		int[] array = new int[] { 1, 1};
		int target = 1;
		CombinationSumII cs = new CombinationSumII();
		List<List<Integer>> list = cs.combinationSum(array, target);
		System.out.println("list.size: " + list.size());
		for (List<Integer> ll : list) {
			for (int i : ll) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
