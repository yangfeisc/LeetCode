package com.leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
	
	/**
	 * 先对整型数组进行排序，然后在排序后的数组中找两个数使得和为target，然后再原数组中找到两个数对应的index
	 * 排序的好处：在判断两个数的和是否为target时，当两个值的和大于target就不用遍历后面的数字，在一定程度
	 * 上减少了遍历的次数。时间复杂度为O(n*m)
	 * @param numbers
	 * @param target
	 * @return
	 */
//	public int[] twoSum(int[] numbers, int target) {
//		int len = numbers.length;
//		Vector<Integer> list = new Vector<Integer>();
//		for(int i=0; i<len; i++) {
//			list.add(numbers[i]);
//		}
//		Collections.sort(list);
//		
//		int num1 = 0, num2 = 0;
//		boolean flag = false;
//		
//		for(int i=0; i<len; i++) {
//			num1 = list.get(i);
//			for(int j=i+1; j<len; j++) {
//				num2 = list.get(j);
//				int sum = num1 + num2;
//				if(sum == target){
//					flag = true;
//					break;
//				}
//				else if(sum > target) {
//					break;
//				}
//			}
//			if(flag) {
//				break;
//			}
//		}
//		
//		int[] index = new int[2];
//		int k = 0;
//		for(int i=0; i<len; i++) {
//			if(numbers[i] == num1 || numbers[i] == num2) {
//				index[k++] = i+1;
//			}
//			if(k == 2) {
//				break;
//			}
//		}
//		return index;
//	}
	
	/**
	 * 通过使用HashMap保存遍历到的数与target的差值，如果在后面的遍历遇到HashMap中的值，则表示两个值
	 * 的和对应于target。
	 * 该方法的时间复杂度为O(n)
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] numbers, int target) {
		int[] index = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int len = numbers.length;
		for(int i=0; i<len; i++) {
			if(!map.containsKey(numbers[i])) {
				map.put(target-numbers[i], i+1);
			} else {
				index[0] = map.get(numbers[i]);
				index[1] = i+1;
				break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner ss = new Scanner(System.in);
		String line = ss.nextLine();
		int target = ss.nextInt();
		
		String[] num = line.split("\\s+");
		int[] numbers = new int[num.length];
		for(int i=0; i<num.length; i++) {
			numbers[i] = Integer.parseInt(num[i]);
		}
		TwoSum ts = new TwoSum();
		int[] index = ts.twoSum(numbers, target);
		System.out.println(index[0] + "\t" + index[1]);
	}
}
