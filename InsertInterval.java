package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into 
 * the intervals (merge if necessary). You may assume that the intervals 
 * were initially sorted according to their start times.
 * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as 
 * [1,5],[6,9].
 * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge 
 * [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * @author yangfei
 *
 */
public class InsertInterval {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
		if(intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}
		int size = intervals.size();
		int[] ele = new int[2*size];
		//将区间映射到数组中
		for(int i=0; i<size; i++) {
			ele[2*i] = intervals.get(i).start;
			ele[2*i+1] = intervals.get(i).end;
		}
		
		int newS = newInterval.start;
		int newE = newInterval.end;
		int i = 0;
		for(; i<ele.length && ele[i]<newInterval.start; i++) {
			if(i % 2 == 1)
				result.add(intervals.get(i/2));
		}
		newS = (i%2==0) ? newInterval.start : ele[i-1];
		if(i == ele.length) {
			newE = newInterval.end;
			result.add(new Interval(newS, newE));
			return result;
		}
		while(i<ele.length && ele[i]<=newInterval.end) {
			i++;
		}
		newE = (i%2==0) ? newInterval.end : ele[i];
		result.add(new Interval(newS, newE));
		while(i < ele.length) {
			if((i+1) % 2 == 1)
				result.add(intervals.get(i/2));
			i++;
		}
		return result;
    }
	
	public static void main(String[] args) {
		InsertInterval ii = new InsertInterval();
		List<Interval> list = new ArrayList<>();
		list.add(ii.new Interval(2, 3));
		list.add(ii.new Interval(4, 7));
		list.add(ii.new Interval(8, 9));
		list.add(ii.new Interval(12, 13));
		List<Interval> result = ii.insert(list, ii.new Interval(0,1));
		for(Interval in : result) {
			System.out.print("[" + in.start + ", " + in.end + "], ");
		}
		System.out.println();
	}
}
