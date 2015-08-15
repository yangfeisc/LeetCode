package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that: Only one letter can
 * be changed at a time Each intermediate word must exist in the dictionary For
 * example, Given: start = "hit" end = "cog" dict =
 * ["hot","dot","dog","lot","log"] Return [ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"] ] Notes:All words have the same length. All
 * words contain only lowercase alphabetic characters.
 * 
 * @author yangfei
 * 
 */
public class WordLadderII {
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> res = new LinkedList<>();
		List<String> list = new LinkedList<>();
		Set<String> queue = new HashSet<>(); //bfs.
		Map<String, Set<String>> map = new HashMap<>();//store all visited strings and their parents
		map.put(start, null);
		queue.add(start);
		boolean flag = false;// whether one of shortest path is found or not.
		while (!queue.isEmpty()) {
			Set<String> qu1 = new HashSet<>();
			for (String temp : queue) {
				StringBuilder sb = new StringBuilder(temp);
				for (int i = 0; i < temp.length(); i++) {
					for (char j = 'a'; j <= 'z'; j++) {
						if (j == temp.charAt(i))
							continue;
						sb.setCharAt(i, j);
						String str = sb.toString();
						if (str.equals(end)) {
							list.add(temp);
							flag = true;
						} else if(dict.contains(str) && !flag) {
							if (qu1.contains(str)) {
								map.get(str).add(temp);
							} else if (!map.containsKey(str)) {
								qu1.add(str);
								Set<String> myset = new HashSet<>();
								myset.add(temp);
								map.put(str, myset);
							}
						}
					}
					sb.setCharAt(i, temp.charAt(i));
				}
			}
			if (flag)
				break;
			queue = qu1;
		}
		// build path
		for (String s : list) {
			List<String> temp = new ArrayList<>();
			temp.add(end);
			findPath(s, start, temp, map, res);
		}
		return res;
	}

	public void findPath(String s, String start, List<String> list,
			Map<String, Set<String>> map, List<List<String>> res) {
		list.add(0, s);
		if (s.equals(start)) {
			res.add(new ArrayList<>(list));
		} else {
			for (String str : map.get(s)) {
				findPath(str, start, list, map, res);
			}
		}
		list.remove(0);
	}

	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		String b = "hit";
		String e = "cog";
		WordLadderII wl = new WordLadderII();
		System.out.println(wl.findLadders(b, e, dict));
	}
}
