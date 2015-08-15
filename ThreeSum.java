package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 方法一：首先，对原序列排序，然后依次遍历序列的元素，设target=0-num[i]作为新的目标值，找两个元素的和等于target；
 * 其次，采用数组剩余元素的首元素和尾元素求和与target比较，如果大的话，则尾元素指针前移，如果小的话，首元素指针后移，
 * 该部分时间复杂度为O(N)。所以总的时间复杂度为O(N^2)。
 * 技巧：
 * 1、因为原数组中可能存在大量重复元素，因此在第一次遍历元素时，如果当前元素与前一个相同，则当前元素对应的3元组肯定在前面
 * 已经得到，因此可以不用考虑，这样可以减少一部分运算，但是这不能完全消除重复，因为3元组中本身就可能有重复。
 * 2、在寻找两个数的和为target时，因为数组有序，因此可以先判断首元素和target的大小关系，如果首元素大于target，则一
 * 定不存在相应的3元组。
 * 
 * 方法二：在找两个元素和等于target时，可以使用hashtable来处理，遍历数组元素，依次将target-num[i]保存到
 * hashtable中，如果后面元素存在于hashtable中，则表示找到了一个2元组，两者之和为target，时间复杂度O(N),
 * 所以方法二的时间复杂度也为O(N^2)。
 * @author yangfei
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
		int len = num.length;
        for(int i=0; i<len-1; i++) {
        	//判断当前元素是否和前一个相同，如果相同，那么这个元素得到的3元组就会和前面得到的重复。
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
