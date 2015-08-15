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
	 * ÿ�ν�result�е�listԪ�شӵ�0��λ�ÿ�ʼ��������������Ȼ��������󽻻��õ����ս����
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
        			List<Integer> ll = new ArrayList<Integer>(subRe); //����list�������޸�ԭlist��ֵ
        			int temp = ll.get(index); //��������ֵ
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
