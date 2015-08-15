package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have 
 * to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return 
 * the ordering of courses you should take to finish all courses. There may be 
 * multiple correct orders, you just need to return one of them. If it is 
 * impossible to finish all courses, return an empty array.
 * For example: 2, [[1,0]] 
 * There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0. So the correct course order is [0,1]
 * 4, [[1,0],[2,0],[3,1],[3,2]] 
 * There are a total of 4 courses to take. To take course 3 you should have 
 * finished both courses 1 and 2. Both courses 1 and 2 should be taken after 
 * you finished course 0. So one correct course order is [0,1,2,3]. Another 
 * correct ordering is[0,2,1,3].
 * @author yangfei
 *
 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0)
        	return new int[0];
        if(prerequisites == null || prerequisites.length == 0) {
        	int[] res = new int[numCourses];
        	for(int i=0; i<numCourses; i++)
        		res[i] = i;
        	return res;
        }
        int row = prerequisites.length;
        int[] degree = new int[numCourses];
        for(int i=0; i<row; i++) {
        	degree[prerequisites[i][0]] += 1;
        }
		int[] res = new int[numCourses];
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<numCourses; i++) {
			if(degree[i] == 0)
				stack.push(i);
		}
		int index = 0;
		while(!stack.isEmpty()) {
			int ele = stack.pop();
			res[index++] = ele;
			degree[ele] = -1;
			for(int i=0; i<row; i++) {
				if(prerequisites[i][1] == ele) {
					degree[prerequisites[i][0]]--;
					if(degree[prerequisites[i][0]] == 0)
						stack.push(prerequisites[i][0]);
				}
			}
		}
		for(int i=0; i<numCourses; i++) {
			if(degree[i] > 0)
				return new int[0];
		}
		return res;
    }
	
	public static void main(String[] args) {
//		int[][] prerequisites = {{1,0},{2,6},{1,7},{5,1},{6,4},{7,0},{5,1},{6,4}};
		int[][] prerequisites = {};
		CourseScheduleII cs = new CourseScheduleII();
		int[] res = cs.findOrder(1, prerequisites);
		System.out.println(Arrays.toString(res));
	}
}
