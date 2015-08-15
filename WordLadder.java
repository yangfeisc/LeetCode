package com.leetcode;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Given two words (beginWord and endWord), and a dictionary, find 
 * the length of shortest transformation sequence from beginWord to 
 * endWord, such that: Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example, Given: start = "hit" end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is 
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Note: Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * @author yangfei
 *
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
        if(wordDict.size() == 0)
        	return 0;
        Queue<String> queue = new LinkedBlockingDeque<String>();
        queue.add(beginWord);
        int step = 1;
        int qSize = queue.size();
        while(!queue.isEmpty()) {
        	String str = queue.poll();
        	qSize--;
        	int diff = 0;
        	for(int i=0; i<str.length(); i++) {
        		if(str.charAt(i) != endWord.charAt(i))
        			diff++;
        		StringBuilder sb = new StringBuilder(str);
        		for(char c='a'; c<='z'; c++) {
        			sb.setCharAt(i, c);
        			if(wordDict.contains(sb.toString())) {
        				queue.add(sb.toString());
        				wordDict.remove(sb.toString());
        			}
        		}
        	}
        	if(diff == 1)
        		return step+1;
        	if(qSize == 0) {
        		step++;
        		qSize = queue.size();
        	}
        }
        return 0;
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
		WordLadder wl = new WordLadder();
		System.out.println(wl.ladderLength(b, e, dict));
	}
}
