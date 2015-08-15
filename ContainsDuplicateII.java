package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1)
            return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k)
                    return true;
            } 
            map.put(nums[i], i);
                
        }
        return false;
    }
}
