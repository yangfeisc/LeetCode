package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key 
 * 			  exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * 			  When the cache reached its capacity, it should invalidate the least 
 * 			  recently used item before inserting a new item.
 * @author yangfei
 *
 */
public class LRUCache {
	private int capacity;
	private Map<Integer, Integer> map;
	private List<Integer> order;  //��¼cache�е�key��Խ�������ʹ�õ�ʱ�������
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        order = new ArrayList<Integer>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        	return -1;
        order.remove(order.indexOf(key));
        order.add(key);   //����Ӧ��key�Ƶ�list����󣬱���ʹ�õ�ʱ������
        return map.get(key);
    }
    
    public void set(int key, int value) {
//    	int val = get(key);
//    	map.put(key, value);
//    	if(val == -1) {
//    		order.add(key);
//    		if(map.size() > capacity) {
//    			map.remove(order.get(0));
//    			order.remove(0);
//    		}
//    	}
    	if(map.containsKey(key)) {
    		order.remove(order.indexOf(key));
    	} else {
    		if(map.size() == capacity) {
    			map.remove(order.get(0));
    			order.remove(0);
    		}
    	}
    	map.put(key, value);
    	order.add(key);
    }
}
