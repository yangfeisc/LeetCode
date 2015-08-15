package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * @author yangfei
 *
 */
public class ImplementTrie_PrefixTree {
	public class TrieNode {
		public boolean isEnd;  //end of a word?
	    public Map<Character, TrieNode> next; //node information
	    public TrieNode() {
	        isEnd = false;
	        next = new HashMap<>();
	    }
	}
	
	private TrieNode root;

    public ImplementTrie_PrefixTree() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
    	TrieNode node = root;
        for (Character c : word.toCharArray()) {
            if (!node.next.containsKey(c)) {
                node.next.put(c, new TrieNode());
            }
            node = node.next.get(c);
        }
        node.isEnd = true;
    }

	// Returns if the word is in the trie.
    public boolean search(String word) {
    	TrieNode node = find(word);
        return node != null && node.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
    	TrieNode node = find(prefix);
        return node != null;
    }
    
    private TrieNode find(String key) {
        TrieNode node = root;
        for (Character c : key.toCharArray()) {
            node = node.next.get(c);
            if (node == null) 
            	return null;
        }
        return node;
    }
}
