package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string 
 * containing only letters a-z or .. A . means it can represent any one letter.
 * For example:	addWord("bad")
 * 	addWord("dad")	addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note: You may assume that all words are consist of lowercase letters a-z.
 * @author yangfei
 *
 */
public class AddAndSearchWord {
	Map<Integer, Set<String>> dict = new HashMap<Integer, Set<String>>();
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null)
            return;
        Set<String> set = new TreeSet<String>();
        if(dict.containsKey(word.length())) {
            set = dict.get(word.length());
        }
        set.add(word);
        dict.put(word.length(), set);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null)
            return false;
        int len = word.length();
        if(!dict.containsKey(len)) 
            return false;
        Set<String> set = dict.get(len);
        boolean flag = true;
        for(String str : set) {
            flag = true;
            for(int j=0; j<len; j++) {
                if(str.charAt(j) != word.charAt(j) && word.charAt(j) != '.') {
                    flag = false;
                    break;
                }   
            }
            if(flag)
                return true;
        }
        return false;
    }
}
