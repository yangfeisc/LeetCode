package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 集合里面存在重复元素，因此子集个数小于2^N.
 * @author yangfei
 *
 */
public class SubSet2 {
	public List<List<Integer>> subsetsWithDup(int[] num) {
        if(num.length == 0 || num == null) 
        	return null;
        Arrays.sort(num);
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
        int N = num.length;
        int len = (int) Math.pow(2, N);
        int isExist;
        for(int i=0; i<len; i++) {
        	List<Integer> list = new ArrayList<>();
        	for(int j=0; j<N; j++) {
        		isExist = (i >> j) & 1;
        		if(isExist == 1) 
        			list.add(num[j]);
        	}
        	if(!subSetExist(result, list))
        		result.add(list);
        }
        return result;
    }
	
	public boolean subSetExist(List<List<Integer>> list, 
			List<Integer> temp) {
		if(list.size() == 0)
			return false;
		boolean exist = false;
		for(int i=0; i<list.size(); i++) {
			int j = 0;
			if(list.get(i).size() == temp.size()) {
				for(; j<temp.size(); j++) {
					if(temp.get(j) != list.get(i).get(j))
						break;
				}
			}
			if(j == temp.size()) {
				exist = true;
				break;
			}
		}
		return exist;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,2,3};
		SubSet2 ss2 = new SubSet2();
		List<List<Integer>> subSet = ss2.subsetsWithDup(num);
		System.out.println(subSet.size());
		for(int i=0; i<subSet.size(); i++) {
			System.out.print("subset" + i + ":\t");
			for(int j=0; i<subSet.get(i).size(); j++) {
				System.out.print(subSet.get(i).get(j) + "  ");
			}
			System.out.println();
		}
	}
}
