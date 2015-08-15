package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should 
 * return true if any value appears at least twice in the array, and it should return false if 
 * every element is distinct.
 * @author yangfei
 *
 */
public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1)
            return false;
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0; i<len; i++) {
            if(set.contains(nums[i]))
                return false;
            else 
                set.add(nums[i]);
        }
        return true;
    }
}
