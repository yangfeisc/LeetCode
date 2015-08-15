package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary 
 * of its ranges. For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author yangfei
 *
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
	    List<String> result = new ArrayList<String>();
	    if(nums.length==0) 
	    	return result;
	    int curr = 1, start = 0;
	    while(curr <= nums.length){
	        if(curr == nums.length || nums[curr]-nums[curr-1] != 1){
	            if(curr-1 == start){
	                result.add(nums[start] + "");
	            }else{
	                result.add(nums[start] + "->" + nums[curr-1]);
	            }
	            start = curr;
	        }
	        curr++;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 3};
		SummaryRanges sr = new SummaryRanges();
		List<String> result = sr.summaryRanges(nums);
		System.out.println(Arrays.toString(result.toArray()));
		
	}
	
}
