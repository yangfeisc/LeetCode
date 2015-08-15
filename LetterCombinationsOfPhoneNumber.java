package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {  
            return res;
        }
        String[] letter = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int index = digits.charAt(0) - '0';
        if(digits.length() == 1) {
            for(int i=0; i<letter[index].length(); i++) 
                res.add(letter[index].charAt(i) + "");
            return res;
        }
        List<String> tmp = letterCombinations(digits.substring(1));
        for(int i=0; i<letter[index].length(); i++) {
            for(String s : tmp) {
                res.add(letter[index].charAt(i) + s);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String digits = "";
		LetterCombinationsOfPhoneNumber lc = new LetterCombinationsOfPhoneNumber();
		List<String> result = lc.letterCombinations(digits);
		for(String s : result) {
			System.out.println(s);
		}
	}
}
