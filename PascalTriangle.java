package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * @author yangfei
 *
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		if(numRows == 0) {
			return new ArrayList<List<Integer>>();
		}
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> preRaw = new ArrayList<Integer>();
        preRaw.add(1);
        result.add(preRaw);
        List<Integer> currRaw = new ArrayList<Integer>();
        for(int i=2; i<=numRows; i++) {
        	currRaw.add(1);
        	for(int j=1; j<i-1; j++) {
        		currRaw.add(preRaw.get(j-1) + preRaw.get(j));
        	}
        	currRaw.add(1);
        	result.add(currRaw);
        	preRaw = currRaw;
        	currRaw = new ArrayList<Integer>();
        }
        return result;
    }
	
	public static void main(String[] args) {
		PascalTriangle pt = new PascalTriangle();
		int k = 3;
		List<List<Integer>> result = pt.generate(k);
		for(List<Integer> li : result) {
			for(Object o : li) {
				System.out.print(o + "\t");
			}
			System.out.println();
		}
	}
}
