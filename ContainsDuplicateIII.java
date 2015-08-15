package com.leetcode;

import java.util.Map;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j 
 * in the array such that the difference between nums[i] and nums[j] is at most t and 
 * the difference between i and j is at most k.
 * @author yangfei
 */
public class ContainsDuplicateIII {
	/**
	 * TreeSet中的floor函数返回小于等于给定元素的最大值，如果没有返回空，
	 * TreeSet中的ceiling函数返回大于等于给定元素的最小值，如果没有返回空，
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length <= 1 || t < 0 || k < 1)
            return false;
        TreeSet<Integer> ts = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
        	if(ts.floor(nums[i])!=null && nums[i]<=t+ts.floor(nums[i])
        			|| ts.ceiling(nums[i])!=null && nums[i]+t>=ts.ceiling(nums[i]))
        		return true;
        	ts.add(nums[i]);
        	if(i >= k)
        		ts.remove(nums[i-k]);
        }
        return false;
    }
	
	/**
	 * 如果: | nums[i]-nums[j] | <= t   式a
	 * 等价: | nums[i]/t - nums[j]/t | <= 1   式b
	 * 推出: | floor(nums[i]/t) - floor(nums[j]/t) | <= 1   式c
	 * ​等价: floor(nums[j]/t) ∈ {floor(nums[i]/t)-1, floor(nums[i]/t), floor(nums[i]/t)+1} 式d
	 * 因此只需要维护一个大小为k的窗口（字典）numDict，其中键为nums[i]/t，值为nums[i]。
	 * 遍历数组nums时，检查nums[i]与键集 {floor(nums[i]/t)-1, floor(nums[i]/t), floor(nums[i]/t)+1} 对应的值的差值即可。
	 * @param nums
	 * @param k
	 * @param t
	 * @return
	 */
	public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
	    if (k < 1 || t < 0) 
	    	return false;
	    Map<Long, Long> map = new java.util.LinkedHashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        long j = (t==0 ? (long)nums[i]-Integer.MIN_VALUE : (((long)nums[i]-Integer.MIN_VALUE)/t));
	        if (map.containsKey(j) || (map.containsKey(j - 1) && Math.abs(map.get(j - 1) - nums[i]) <= t)
	                || (map.containsKey(j + 1) && Math.abs(map.get(j + 1) - nums[i]) <= t)) 
	        	return true;
	        if (map.size() == k) 
	        	map.remove(map.keySet().iterator().next());
	        map.put(j, (long) nums[i]);
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		int[] num = {-1, -1};
		ContainsDuplicateIII cd = new ContainsDuplicateIII();
		System.out.println(cd.containsNearbyAlmostDuplicate(num, 1, 0));
		System.out.println(cd.containsNearbyAlmostDuplicate2(num, 1, 0));
	}
}
