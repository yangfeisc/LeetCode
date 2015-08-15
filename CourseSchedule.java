package com.leetcode;

import java.util.Stack;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have 
 * to first take course 1, which is expressed as a pair: [0,1] 
 * Given the total number of courses and a list of prerequisite pairs, is it 
 * possible for you to finish all courses?
 * For example: 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have 
 * finished course 0. So it is possible. 
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished 
 * course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * @author yangfei
 *
 */
public class CourseSchedule {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if(numCourses == 0 || prerequisites.length == 0)
			return true;
		int row = prerequisites.length;
		int[] degree = new int[numCourses];
		//设置每门课的前序课程数
		for(int i=0; i<row; i++) {
			degree[prerequisites[i][0]] += 1;
		}
		Stack<Integer> stack = new Stack<>(); //记录度为0的元素
		for(int i=0; i<numCourses; i++) {
			if(degree[i] == 0)
				stack.push(i);
		}
		//不断移除度为0的课程，并将以该课程为前序课程的课程的度减1.
		while(!stack.isEmpty()) {
			int ele = stack.pop();
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
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[][] prerequisites = {{1,0}, {2,6},{1,7},{5,1},{6,4},{7,0},{0,5},{5,1},{6,4}};
		CourseSchedule cs = new CourseSchedule();
		System.out.println(cs.canFinish(8, prerequisites));
	}
}
