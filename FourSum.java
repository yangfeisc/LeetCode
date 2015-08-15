package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0; i<len-2; i++) {
            if(i>0 && nums[i] == nums[i-1])
                continue;
            for(int j=i+1; j<len-1; j++) {
                if(j>i+1 && nums[j] == nums[j-1]) 
                    continue;
                int nTarget = target - nums[i] - nums[j];
                int b = j+1, e = len - 1;
                while(b < e) {
                    if(nums[b] + nums[e] < nTarget) 
                        b++;
                    else if(nums[b] + nums[e] > nTarget)
                        e--;
                    else {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[b]);
                        tmp.add(nums[e]);
                        if(!res.contains(tmp))
                            res.add(tmp);
                        b++;
                        e--;
                    }
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] num = new int[]{-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9;
		FourSum fs = new FourSum();
		List<List<Integer>> list = fs.fourSum(num, target);
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.get(i).size(); j++) {
				System.out.print(list.get(i).get(j) + "\t");
			}
			System.out.println();
		}
	}
}
