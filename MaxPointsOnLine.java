package com.leetcode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

// Definition for a point
class Point {
	int x;
    int y;
    Point() { 
    	x = 0; 
    	y = 0; 
    }
    Point(int a, int b) { 
    	x = a; 
    	y = b; 
    }
}
 
public class MaxPointsOnLine {
	public int maxPoints(Point[] points) {
		int len = points.length;
		if(len < 2)
			return len;
		int max = 1;
		for(int i=0; i<len-1; i++) {
			int duli = 0;
			Map<Double, Vector<Point>> list = new TreeMap<Double, Vector<Point>>();  //用于保存不同斜率的直线，相同斜率对应的点存在一个vector中
			for(int j=i+1; j<len; j++) {
				if(points[j].x==points[i].x && points[j].y == points[i].y) {   //当存在重复元素时，无法计算斜率，所以需要单独考虑
					duli++;
					
				} else {
					double k = (double)(points[i].y-points[j].y) / (points[i].x-points[j].x); //计算斜率
					if (k == -0)                    //斜率为-0和0时对应同一条直线
						k = 0;
					if (Double.isInfinite(k))       //斜率为-infinite和infinite对应同一条直线
						k = Double.POSITIVE_INFINITY;
					if(list.containsKey(k)) {      //如果对应的斜率已经存在，则只考虑将对应的点加到vector中
						Vector<Point> vec = list.get(k);
						if(!vec.contains(points[i])) 
							vec.add(points[i]);
						if(!vec.contains(points[j]))
							vec.add(points[j]);
						list.put(k, vec);
					} else {                       //对应的斜率不存在，则将斜率以及对应的点加到list中
						Vector<Point> v = new Vector<Point>();   
						v.add(points[i]);
						v.add(points[j]);
						list.put(k, v);
					}
				}
			}
			System.out.println(duli);
			if(list.size() > 0) {
				Iterator<Double> iter = list.keySet().iterator();
				while(iter.hasNext()) {
					double key = iter.next();
					if(max < (list.get(key).size()+duli)) {
						max = list.get(key).size() + duli;
					}
				}
			} else {
				if(max < duli +1)			
					max = duli + 1;
			}
		}
		
		return max;
    }
	
	public static void main(String[] args) {
//		int[] x = new int[] {0,5,2,0,1,2,5,3,-2,-1,0,0,-2,0,0};
//		int[] y = new int[] {-12,2,5,-5,5,-2,-4,4,4,4,-5,-8,-1,-11,-9};
//		Point[] point = new Point[15];
		int[] x = new int[] {1,1,1};
		int[] y = new int[] {1,1,1};
		Point[] point = new Point[3];
		
		MaxPointsOnLine mpol = new MaxPointsOnLine();
		
		for(int i=0; i<3; i++) {
			point[i] = new Point(x[i], y[i]);
			System.out.println(point[i].x + "\t" + point[i].y);
		}
		
		int num = mpol.maxPoints(point);
		System.out.println(num);
	}
}
