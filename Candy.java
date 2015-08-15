package com.leetcode;

import java.util.Scanner;

public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        for(int i=0; i<candy.length; i++) {
        	candy[i] = 1;
        }
        for(int i=1; i<len-1; i++) {
        	if(ratings[i]>ratings[i-1]) {
        		candy[i] += candy[i-1];
        	} 
        }
        for(int i=len-2; i>=0; i--) {
        	if(ratings[i]>ratings[i+1] && candy[i]<candy[i+1]+1) {
        		candy[i] = candy[i+1] + 1;
        	}
        }
        int sum = 0;
        for(int i=0; i<candy.length; i++) {
        	System.out.print(candy[i] + "  ");
        	sum += candy[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner ss = new Scanner(System.in);
		String input = ss.nextLine();
		String[] rate = input.split("\\s+");
		int[] rating = new int[rate.length];
		for(int i=0; i<rate.length; i++) {
			rating[i] = Integer.parseInt(rate[i]);
		}
		Candy solution = new Candy();
		int candy = solution.candy(rating);
		System.out.println("\n" + candy);
	}
}
