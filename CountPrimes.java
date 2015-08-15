package com.leetcode;

import java.util.Arrays;

/**
 * Count the number of prime numbers less than a non-negative number, n
 * Hint: The number n could be in the order of 100,000 to 5,000,000.
 * @author yangfei
 *
 */
public class CountPrimes {
	public int countPrimes(int n) {
		int[] arr = new int[n];
		for(int i=3; i<n; i++) {
			if(i % 2 == 0)
				arr[i] = 1; //2的倍数
			else 
				arr[i] = 0;
		}
		for(int i=3; i<n; i++) {
			if(arr[i] == 0) {
				if(i*i > n)
					break;
				for(int j=2; j*i<n; j++) { //i的倍数
					arr[i*j] = 1;
				}
			}
		}
		int count = 0;
		System.out.println(Arrays.toString(arr));
		for(int i=2; i<n; i++) 
			if(arr[i] == 0)
				count++;
		return count;
    }
	
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes(10));
	}
}
