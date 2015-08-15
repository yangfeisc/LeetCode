package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中的元素可以1次或者多次的使用来组合target
 * 使用递归求解
 * @author yangfei
 * 
 */
public class CombinationSum {

	private List<List<Integer>> result = new ArrayList<>();
	private List<Integer> solu = new ArrayList<>();

/**
 * 方法一：排序后从小到大进行遍历，判断选择的序列的值是否等于target。
 * @param candidates
 * @param target
 * @return
 */
//	public List<List<Integer>> combinationSum(int[] candidates, int target) {
//		Arrays.sort(candidates);
//		getCombination(candidates, target, 0, 0);
//		return result;
//	}
//
//	public void getCombination(int[] candidates, int target, int sum, int level) {
//		if (sum > target)
//			return;
//		if (sum == target) {
//			result.add(new ArrayList<>(solu));
//			return;
//		}
//		for (int i = level; i < candidates.length; i++) {
//			sum += candidates[i];
//			solu.add(candidates[i]);
//			getCombination(candidates, target, sum, i);
//			solu.remove(solu.size() - 1);
//			sum -= candidates[i];
//		}
//	}
	
	/**
	 * 方法二：排序后从小于等于target的最后一个数向前遍历，得到对应的序列等于target的值，但是这样得到的序列
	 * 是从大到小排序的，因此在最后还需要将序列进行反序。
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		int tail = candidates.length-1;
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
			result.add(new ArrayList<>(solu));
			return;
		}
		for (int i = level; i >= 0; i--) {
			sum += candidates[i];
			solu.add(0, candidates[i]);
			getCombination(candidates, target, sum, i);
			solu.remove(0);
			sum -= candidates[i];
		}
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1};
		int target = 2;
		CombinationSum cs = new CombinationSum();
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
