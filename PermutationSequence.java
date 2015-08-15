package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,��,n] contains a total of n! unique permutations. By listing
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
		List<Character> temp = new ArrayList<Character>(n); // ����1~n
		for (int i = 1; i <= n; i++) {
			temp.add((char) (i + '0'));
			factoral *= i;  //��n!
		}
		factoral /= n;
		StringBuilder result = new StringBuilder(n); // ������
		int index = k / factoral; // Ӧ��ѡ��ڼ���Ԫ����Ϊ�������Ԫ��
		if (index > n) // k>n!
			return "";
		k = k - (k / factoral) * factoral; // �жϽ��������Ԫ��ȷ�����еĵڼ���
		int len = n - 1;
		while (k > 0) { //�������ж�Ӧtemp[index]Ϊ��Ԫ�صĵ�k�����С�
			result.append(temp.get(index)); // �����ж϶�Ӧ����Ԫ��
			temp.remove(index); // Ϊ�˺���index�жϷ��㣬���ϵؼ���temp��Ԫ�أ����ӵ�������е�Ԫ��ȥ��
			factoral = factoral / (len--); // ÿ��ѭ����(len-1)!ֱ��len=0�����������ϴ���õ�factoral��
			index = k / factoral; // �ж���һ��Ԫ�ض�Ӧ������
			k = k - (k / factoral) * factoral; // �ж�Ԫ�ش��ڵڼ�����
		}
		result.append(temp.get(index - 1)); // k=0�����������ö�Ӧtemp[index-1]Ϊ��Ԫ�ص����һ������
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
