package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example, Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * @author yangfei
 *
 */
public class MergeIntervals {
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	/**
	 * 由于区间之间的顺序不确定，所以需要先对区间根据每个区间的起始进行排序。
	 * @param intervals
	 * @return
	 */
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0)
        	return new ArrayList<Interval>();
        List<Interval> result = new ArrayList<Interval>();
        
        int size = intervals.size();
        //使用匿名类进行排序
        Comparator<Interval> comparator = new Comparator<Interval>() {
        	public int compare(Interval I1, Interval I2) {
        		return I1.start - I2.start;
        	}
		};
		Collections.sort(intervals, comparator);
		
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(int i=1; i<size; i++) {
        	if(end >= intervals.get(i).start) {
        		start = start<intervals.get(i).start ? 
        				start : intervals.get(i).start;
        		end = end>intervals.get(i).end ? end : intervals.get(i).end;
        	} else {
        		result.add(new Interval(start, end));
        		start = intervals.get(i).start;
        		end = intervals.get(i).end;
        	}
        }
        result.add(new Interval(start, end));
        return result;
    }
	
	public static void main(String[] args) {
		MergeIntervals ii = new MergeIntervals();
		List<Interval> list = new ArrayList<>();
		list.add(ii.new Interval(3, 7));
		list.add(ii.new Interval(0, 0));
		list.add(ii.new Interval(6, 9));
		list.add(ii.new Interval(12, 13));
		List<Interval> result = ii.merge(list);
		for(Interval in : result) {
			System.out.print("[" + in.start + ", " + in.end + "], ");
		}
		System.out.println();
	}
}
