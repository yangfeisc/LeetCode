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
			Map<Double, Vector<Point>> list = new TreeMap<Double, Vector<Point>>();  //���ڱ��治ͬб�ʵ�ֱ�ߣ���ͬб�ʶ�Ӧ�ĵ����һ��vector��
			for(int j=i+1; j<len; j++) {
				if(points[j].x==points[i].x && points[j].y == points[i].y) {   //�������ظ�Ԫ��ʱ���޷�����б�ʣ�������Ҫ��������
					duli++;
					
				} else {
					double k = (double)(points[i].y-points[j].y) / (points[i].x-points[j].x); //����б��
					if (k == -0)                    //б��Ϊ-0��0ʱ��Ӧͬһ��ֱ��
						k = 0;
					if (Double.isInfinite(k))       //б��Ϊ-infinite��infinite��Ӧͬһ��ֱ��
						k = Double.POSITIVE_INFINITY;
					if(list.containsKey(k)) {      //�����Ӧ��б���Ѿ����ڣ���ֻ���ǽ���Ӧ�ĵ�ӵ�vector��
						Vector<Point> vec = list.get(k);
						if(!vec.contains(points[i])) 
							vec.add(points[i]);
						if(!vec.contains(points[j]))
							vec.add(points[j]);
						list.put(k, vec);
					} else {                       //��Ӧ��б�ʲ����ڣ���б���Լ���Ӧ�ĵ�ӵ�list��
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
