package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 * For example,[1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * @author yangfei
 *
 */
public class PermutationsII {
	
	/**
	 * 每次将result中的list元素从第0个位置开始交换并保存结果，然后依次向后交换得到最终结果。
	 * @param num
	 * @return
	 */
	public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        for(int i=0; i<num.length; i++) {
        	sub.add(num[i]);
        }
        result.add(sub);
        int index = 0;
        while(index < num.length) {
        	int size = result.size();
        	for(int i=0; i<size; i++) {
        		List<Integer> subRe = result.get(i);
        		for(int j=index+1; j<num.length; j++) {
        			List<Integer> ll = new ArrayList<Integer>(subRe); //拷贝list，避免修改原list的值
        			int temp = ll.get(index); //交换两个值
        			ll.set(index, ll.get(j)); 
        			ll.set(j, temp);
        			if(!result.contains(ll)) {
        				result.add(ll);
        			}
        		}
        	}
        	index++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] num = {1,1,2};
		PermutationsII pe = new PermutationsII();
		List<List<Integer>> result = pe.permuteUnique(num);
		for(List<Integer> ll : result) {
			System.out.println(ll);
		}
	}
}
