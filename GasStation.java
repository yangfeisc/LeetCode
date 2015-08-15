package com.leetcode;

import java.util.Scanner;

public class GasStation {
	/**
	 * 该方法通过对每个起点进行测试，时间复杂度为O(n^2)
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
	 * 如果从一个起点A到另一个加油站B剩余油量小于0，那么从A到B之间任何加油站都不能到达B。
	 * 因为加油站围成一个圈，所以遍历时需要考虑从后到前，即从A->N->A模式，因此在实现过程中
	 * 可以遍历两遍，时间复杂度为O(n).
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
