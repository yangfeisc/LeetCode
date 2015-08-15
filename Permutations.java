package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * For example, [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author yangfei
 *
 */
public class Permutations {
	//将第0个字符和从第0开始的每个字符进行交换，对于交换后的结果，再从第1个字符开始交换。一直到最后一个字符。
	public List<List<Integer>> permute(int[] num) {
		if(num.length <= 0) 
			return null;

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> subResult = new ArrayList<Integer>();
		
		List<Integer> element = new ArrayList<Integer>();
		for(int i=0; i<num.length; i++) {
			element.add(num[i]);
		}
		subPermute(element, subResult, result);
		
		return result;
    }
	
	public void subPermute(List<Integer> num, List<Integer> subResult, 
			List<List<Integer>> result) {
		if(num.size() == 0) {
			result.add(new ArrayList<Integer>(subResult));
			return;
		}
		for(int i=0; i<num.size(); i++) {
			int index = num.get(i);
			num.set(i, num.get(0));
			num.set(0, index);
			subResult.add(index);
			subPermute(num.subList(1, num.size()), subResult, result);
			int ele = num.get(i);
			num.set(i, index);   //将交换后的数组还原
			num.set(0, ele);
			subResult.remove(subResult.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3};
		Permutations permutation = new Permutations();
		List<List<Integer>> result = permutation.permute(array);
		for(int i=0; i<result.size(); i++) {
			for(int j=0; j<result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}
