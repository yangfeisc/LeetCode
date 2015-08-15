package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：首先对数组进行排序，然后将每个数字用1bit表示，通过遍历n位的组合得到对应的subsets
 * @author yangfei
 *
 */
public class SubSets {
	public List<List<Integer>> subsets(int[] S) {
		if(S == null || S.length == 0) {
			return null;
		}
		Arrays.sort(S);
		int N = S.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int isExist;
        for(int i=0; i<Math.pow(2, N); i++) {
        	List<Integer> l = new ArrayList<Integer>();
        	for(int j=0; j<N; j++) {
        		isExist = (i >> j) & 1;
        		if(isExist == 1) {
        			l.add(S[j]);
        		}
        	}
        	list.add(l);
        }
        return list;
    }
	
	public static void main(String[] args) {
		int[] S = {0};
		SubSets ss = new SubSets();
		List<List<Integer>> list = ss.subsets(S);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
