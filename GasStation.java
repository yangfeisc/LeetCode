package com.leetcode;

import java.util.Scanner;

public class GasStation {
	/**
	 * �÷���ͨ����ÿ�������в��ԣ�ʱ�临�Ӷ�ΪO(n^2)
	 * @param gas
	 * @param cost
	 * @return
	 */
//	public int canCompleteCircuit(int[] gas, int[] cost) {
//		int N = gas.length;
//		int totalGas = 0;
//		int totalCost = 0;
//		for (int i = 0; i < N; i++) {
//			totalGas += gas[i];
//			totalCost += cost[i];
//		}
//		if (totalGas < totalCost) {
//			return -1;
//		}
//		boolean flag = true;
//		for (int i = 0; i < N; i++) {
//			flag = true;
//			int difference = gas[i] - cost[i];
//			if (difference >= 0) {
//				for (int j = i + 1; j < N; j++) {
//					difference += gas[j] - cost[j];
//					if(difference < 0) {
//						flag = false;
//						break;
//					}
//				}
//				for (int k = 0; k < i && flag; k++) {
//					difference += gas[k] - cost[k];
//					if(difference < 0) {
//						flag = false;
//						break;
//					}
//				}
//				if(flag) {
//					return i;
//				}
//			}
//		}
//		return -1;
//	}
	
	/**
	 * �����һ�����A����һ������վBʣ������С��0����ô��A��B֮���κμ���վ�����ܵ���B��
	 * ��Ϊ����վΧ��һ��Ȧ�����Ա���ʱ��Ҫ���ǴӺ�ǰ������A->N->Aģʽ�������ʵ�ֹ�����
	 * ���Ա������飬ʱ�临�Ӷ�ΪO(n).
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int begin = 0;
		int N = gas.length;
		int left = 0;
		for(int i=0; i<2*N; i++) {
			int k = i%N;
			left += gas[k] - cost[k];
			if(left < 0) {
				left = 0;
				begin = i+1;
			}
		}
		if(begin > N) {
			return -1;
		} else {
			return begin;
		}
	}
	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner ss = new Scanner(System.in);
		String in1 = ss.nextLine();
		String in2 = ss.nextLine();
		String[] str1 = in1.split("\\s+");
		String[] str2 = in2.split("\\s+");
		int[] gas = new int[str1.length];
		int[] cost = new int[str2.length];
		for(int i=0; i<str1.length; i++) {
			gas[i] = Integer.parseInt(str1[i]);
			cost[i] = Integer.parseInt(str2[i]);
		}
		GasStation gs = new GasStation();
		int result = gs.canCompleteCircuit(gas, cost);
		System.out.println(result);
	}
}
