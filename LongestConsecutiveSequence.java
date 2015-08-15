package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest 
 * consecutive elements sequence. 
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive 
 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * @author yangfei
 *
 */
public class LongestConsecutiveSequence {
	/**
	 * 先排序，后遍历找到连续的序列长度，相同的元素不影响长度。
	 * 时间复杂度O(nlogn)
	 * @param nums
	 * @return
	 */
	public int longestConsecutive1(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int max = 1;
        int tmp = 1;
        for(int i=1; i<nums.length; i++) {
        	if(nums[i] == nums[i-1])
        		continue;
        	else if(nums[i] == nums[i-1]+1) {
                tmp++;
                max = max>tmp ? max : tmp;
            } else {
                tmp = 1;
            }
        }
        return max;
    }
	
	public int longestConsecutive2(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		for(int i=0; i<nums.length; i++) {
			if(map.containsKey(nums[i]))
				continue;
			map.put(nums[i], 1);
			int begin = nums[i];
			int end = nums[i];
			if(map.containsKey(nums[i] - 1))
				begin = nums[i] - map.get(nums[i]-1);
			if(map.containsKey(nums[i] + 1))
				end = nums[i] + map.get(nums[i]+1);
			max = max > (end-begin+1) ? max : (end-begin+1);
			map.put(begin, end - begin + 1);
			map.put(end, end - begin + 1);
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
		LongestConsecutiveSequence lc = new LongestConsecutiveSequence();
		System.out.println(lc.longestConsecutive1(nums));
		System.out.println(lc.longestConsecutive2(nums));
	}
}
