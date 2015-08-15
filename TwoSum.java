package com.leetcode;

import java.util.HashMap;
import java.util.Scanner;

public class TwoSum {
	
	/**
	 * �ȶ����������������Ȼ������������������������ʹ�ú�Ϊtarget��Ȼ����ԭ�������ҵ���������Ӧ��index
	 * ����ĺô������ж��������ĺ��Ƿ�Ϊtargetʱ��������ֵ�ĺʹ���target�Ͳ��ñ�����������֣���һ���̶�
	 * �ϼ����˱����Ĵ�����ʱ�临�Ӷ�ΪO(n*m)
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
	 * ͨ��ʹ��HashMap���������������target�Ĳ�ֵ������ں���ı�������HashMap�е�ֵ�����ʾ����ֵ
	 * �ĺͶ�Ӧ��target��
	 * �÷�����ʱ�临�Ӷ�ΪO(n)
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
