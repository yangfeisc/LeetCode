package com.leetcode;

import java.util.Scanner;

public class ReverseWords {
	public String reverseWords(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        String reverse = "";
        String[] str = s.split(" ");
        int len = str.length;
        for(int i=len-1; i>=0; --i) {
        	if(!str[i].equals("")) {
        		reverse += str[i] + " ";
        	}
        }
        int size = reverse.length();
        if(size == 0) {
            reverse = "";
        } else {
            reverse = reverse.substring(0, size-1);
        }
        return reverse;
		
	}
    
    public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner ss = new Scanner(System.in);
		String input = ss.nextLine();
		ReverseWords s = new ReverseWords();
		String output = s.reverseWords(input);
		System.out.println(output);
	}
}
