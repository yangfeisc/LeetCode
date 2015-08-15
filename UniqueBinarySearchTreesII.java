package com.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * Given n, generate all structurally unique BST's (binary search trees) 
 * that store values 1...n. For example, Given n = 3, your program should 
 * return all 5 unique BST's shown below.
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * @author yangfei
 */
public class UniqueBinarySearchTreesII {
	/**
	 * 使用递归进行求解
	 * @param n
	 * @return
	 */
	public List<TreeNode> generateTrees(int n) {
        return BST(1, n);
    }
	
	public List<TreeNode> BST(int left, int right) {
		List<TreeNode> result = new ArrayList<>();
		if(left > right) {
			result.add(null);
			return result;
		}
		for(int i=left; i<= right; i++) {
			List<TreeNode> lTree = BST(left, i-1);
			List<TreeNode> rTree = BST(i+1, right);
			for(int j=0; j<lTree.size(); j++) {
				for(int k=0; k<rTree.size(); k++) {
					TreeNode tn = new TreeNode(i);
					tn.left = lTree.get(j);
					tn.right = rTree.get(k);
					result.add(tn);
				}
			}
		}
		return result;
	}
	
}
