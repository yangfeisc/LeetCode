package com.leetcode;

public class PowerXN {
	public double pow(double x, int n) {
        if(n == 0)
        	return 1.0;
        if(n < 0) {
        	if(n == Integer.MIN_VALUE) {
        		int newN = -(n + 1);
        		return 1.0 / (pow(x, newN) * x);
        	} else
        		return 1.0 / pow(x, -n);
        }
        double half = pow(x, n>>1);
        if(n % 2 == 0)
        	return half * half;
        else 
        	return half * half * x;
    }
	
	public static void main(String[] args) {
		double x = 34.00515;
		int n = -3;
		PowerXN px = new PowerXN();
		double result = px.pow(x, n);
		System.out.println("result: " + result);
	}
}
