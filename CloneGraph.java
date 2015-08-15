package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Clone an undirected graph. Each node in the graph contains a label 
 * and a list of its neighbors.
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node 
 * label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}. The graph 
 * has a total of three nodes, and therefore contains three parts as 
 * separated by #. First node is labeled as 0. Connect node 0 to both 
 * nodes 1 and 2. Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus 
 * forming a self-cycle. Visually, the graph looks like the following:
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 * @author yangfei
 *
 */
public class CloneGraph {
	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
	}
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		queue.add(node);
		Set<UndirectedGraphNode> visited = new HashSet<>();
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>(); //key原节点，value新节点
		while (!queue.isEmpty()) {
			UndirectedGraphNode n = queue.poll();
			if (visited.contains(n))
				continue;
			visited.add(n);
			UndirectedGraphNode clone;
			if (!map.containsKey(n)) {
				clone = new UndirectedGraphNode(n.label);
				map.put(n, clone);
			} else {
				clone = map.get(n);
			}
			for (UndirectedGraphNode un : n.neighbors) {
				queue.add(un);
				UndirectedGraphNode cloneChild;
				if (!map.containsKey(un)) {
					cloneChild = new UndirectedGraphNode(un.label);
					map.put(un, cloneChild);
				} else {
					cloneChild = map.get(un);
				}
				clone.neighbors.add(cloneChild);
			}
		}
		return map.get(node);
	}
	
	public static void main(String[] args) {
		CloneGraph cg = new CloneGraph();
		UndirectedGraphNode node = cg.new UndirectedGraphNode(0);
		node.neighbors.add(node);
		node.neighbors.add(node);
		UndirectedGraphNode un = cg.cloneGraph(node);
		System.out.println(un.label);
		for(int i=0; i<un.neighbors.size(); i++) {
			System.out.print(un.neighbors.get(i).label + "\t");
		}
		System.out.println();
	}
}
