package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations. By listing
 * and labeling all of the permutations in order, We get the following sequence
 * (ie, for n = 3): 1. "123" 2. "132" 3. "213" 4. "231" 5. "312" 6. "321" Given
 * n and k, return the k-th permutation sequence.
 * 
 * @author yangfei
 * 
 */
public class PermutationSequence {
	public String getPermutation(int n, int k) {
		if (n == 0 || k == 0)
			return "";
		int factoral = 1;
		List<Character> temp = new ArrayList<Character>(n); // 保存1~n
		for (int i = 1; i <= n; i++) {
			temp.add((char) (i + '0'));
			factoral *= i;  //求n!
		}
		factoral /= n;
		StringBuilder result = new StringBuilder(n); // 保存结果
		int index = k / factoral; // 应该选择第几个元素作为结果的首元素
		if (index > n) // k>n!
			return "";
		k = k - (k / factoral) * factoral; // 判断结果处于首元素确定排列的第几个
		int len = n - 1;
		while (k > 0) { //所求排列对应temp[index]为首元素的第k个排列。
			result.append(temp.get(index)); // 依次判断对应排列元素
			temp.remove(index); // 为了后面index判断方便，不断地减少temp中元素，将加到结果集中的元素去掉
			factoral = factoral / (len--); // 每次循环求(len-1)!直到len=0，可以利用上次求得的factoral。
			index = k / factoral; // 判断下一个元素对应的索引
			k = k - (k / factoral) * factoral; // 判断元素处于第几个。
		}
		result.append(temp.get(index - 1)); // k=0所求排列正好对应temp[index-1]为首元素的最后一个排列
		temp.remove(index - 1);
		for (int i = temp.size() - 1; i >= 0; i--) {
			result.append(temp.get(i));
		}
		return result.toString();
	}

	public static void main(String[] args) {
		PermutationSequence per = new PermutationSequence();
		System.out.println(per.getPermutation(4, 6));
	}
}
