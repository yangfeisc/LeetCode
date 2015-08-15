package com.leetcode;

//import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more than [n/2] times.
 * You may assume that the array is non-empty and the majority 
 * element always exist in the array.
 * @author yangfei
 *
 */
public class MajorityElement {
	/**
	 * ֱ������Ȼ���ҵ���Ӧ��[n/2]Ԫ�ؼ�Ϊ����ʱ�临�Ӷ�O(nlogn)��
	 * @param num
	 * @return
	 */
//	public int majorityElement(int[] num) {
//        Arrays.sort(num);
//        return num[num.length/2];
//    }
	
	/**
	 * ʹ��HashMapʵ�֣�ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
	 * @param num
	 * @return
	 */
	public int majorityElement(int[] num) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<num.length; i++) {
			if(map.containsKey(num[i])) {
				map.put(num[i], map.get(num[i])+1);
			} else {
				map.put(num[i], 1);
			}
		}
		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext()) {
			int key = iter.next();
			if(map.get(key) > num.length/2)
				return key;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] num = {1,2,3,1,2,1,1};
		MajorityElement me = new MajorityElement();
		int result = me.majorityElement(num);
		System.out.println(result);
	}
}
