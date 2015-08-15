package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ�����ȣ���ԭ��������Ȼ�����α������е�Ԫ�أ���target=0-num[i]��Ϊ�µ�Ŀ��ֵ��������Ԫ�صĺ͵���target��
 * ��Σ���������ʣ��Ԫ�ص���Ԫ�غ�βԪ�������target�Ƚϣ������Ļ�����βԪ��ָ��ǰ�ƣ����С�Ļ�����Ԫ��ָ����ƣ�
 * �ò���ʱ�临�Ӷ�ΪO(N)�������ܵ�ʱ�临�Ӷ�ΪO(N^2)��
 * ���ɣ�
 * 1����Ϊԭ�����п��ܴ��ڴ����ظ�Ԫ�أ�����ڵ�һ�α���Ԫ��ʱ�������ǰԪ����ǰһ����ͬ����ǰԪ�ض�Ӧ��3Ԫ��϶���ǰ��
 * �Ѿ��õ�����˿��Բ��ÿ��ǣ��������Լ���һ�������㣬�����ⲻ����ȫ�����ظ�����Ϊ3Ԫ���б���Ϳ������ظ���
 * 2����Ѱ���������ĺ�Ϊtargetʱ����Ϊ����������˿������ж���Ԫ�غ�target�Ĵ�С��ϵ�������Ԫ�ش���target����һ
 * ����������Ӧ��3Ԫ�顣
 * 
 * ����������������Ԫ�غ͵���targetʱ������ʹ��hashtable��������������Ԫ�أ����ν�target-num[i]���浽
 * hashtable�У��������Ԫ�ش�����hashtable�У����ʾ�ҵ���һ��2Ԫ�飬����֮��Ϊtarget��ʱ�临�Ӷ�O(N),
 * ���Է�������ʱ�临�Ӷ�ҲΪO(N^2)��
 * @author yangfei
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = num.length;
        for(int i=0; i<len-1; i++) {
        	//�жϵ�ǰԪ���Ƿ��ǰһ����ͬ�������ͬ����ô���Ԫ�صõ���3Ԫ��ͻ��ǰ��õ����ظ���
        	if(i>0 && num[i] == num[i-1]) 
        		continue;
        	int tempResult = 0 - num[i];
        	int j = i + 1;
        	int k = len - 1;
        	while(j < k) {
        		if(num[j] > tempResult)
        			break;
        		if(num[j] + num[k] < tempResult) {
        			j++;
        		} else if(num[j] + num[k] > tempResult) {
        			k--;
        		} else {
        			List<Integer> temp = new ArrayList<Integer>();
        			temp.add(num[i]);
        			temp.add(num[j]);
        			temp.add(num[k]);
        			if(!result.contains(temp))
        				result.add(temp);
        			j++;
        			k--;
        		}
        	}
        	
//        	Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
//        	for(int j=i+1; j<len; j++) {
//        		List<Integer> temp = new ArrayList<Integer>();
//        		if(table.containsKey(num[j])) {
//        			temp.add(num[i]);
//        			temp.add(num[table.get(num[j])]);
//        			temp.add(num[j]);
//        			result.add(temp);
//        		} else {
//        			table.put(tempResult-num[j], j);
//        		}
//        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] num = new int[]{-9,14,-7,-8,9,1,-10,-8,13,12,6,9,3,-3,-15,-15,1,8,-7,-4,-6,8,2,-10,8,11,-15,3,0,-11,-1,-1,10,0,6,5,-14,3,12,-15,-7,-5,9,11,-1,1,3,-15,-5,11,-12,-4,-4,-2,-6,-10,-6,-6,0,2,-9,14,-14,-14,-9,-1,-2,-7,-12,-13,-15,-4,-3,1,14,3,-12,3,3,-10,-9,-1,-7,3,12,-6,0,13,4,-15,0,2,6,1,3,13,8,-13,13,11,11,13,14,-6};
		ThreeSum ts = new ThreeSum();
		List<List<Integer>> result = ts.threeSum(num);
		System.out.println("Result: ");
		for(int i=0; i<result.size(); i++) {
			for(int j=0; j<result.get(i).size(); j++) {
				System.out.print(result.get(i).get(j) + "\t");
			}
			System.out.println();
		}
	}
}
